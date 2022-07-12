package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTOCreate;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PessoaService pessoaService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    EmailService emailService;
    public List<EnderecoDTO> list(){
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    
    public List<EnderecoDTO> listPorId(Integer id) throws RegraDeNegocioException {
        findById(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id)).map(endereco -> objectMapper.convertValue(endereco,EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listPorIdPessoa(Integer id) throws RegraDeNegocioException {
        pessoaService.findById(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id)).map(endereco -> objectMapper.convertValue(endereco,EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoDTOCreate endereco) throws RegraDeNegocioException {
        Pessoa pessoaValida = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco,Endereco.class);
        log.info("Criando endereço....");
        Endereco enderecoCriado = enderecoRepository.create(enderecoEntity);
        enderecoEntity.setIdPessoa(idPessoa);
        log.info("Endereço criado!");
        emailService.emailCadastroEndereco(objectMapper.convertValue(enderecoCriado,EnderecoDTO.class),objectMapper.convertValue(pessoaValida, PessoaDTO.class));
        return objectMapper.convertValue(enderecoCriado,EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoDTOCreate enderecoAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaValida = pessoaService.findById(id);
        Endereco enderecoRecuperado = findById(id);
        objectMapper.convertValue(enderecoAtualizar,Endereco.class);
        log.info("Atualizando endereço....");
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        log.info("Endereço atualizado!");
        emailService.emailAtualizacaoEndereco(objectMapper.convertValue(enderecoRecuperado,EnderecoDTO.class),objectMapper.convertValue(pessoaValida,PessoaDTO.class));
        return objectMapper.convertValue(enderecoRecuperado,EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco endereco = findById(id);
        Pessoa pessoa = pessoaService.findById(endereco.getIdPessoa());
        log.info("Deletendo endereço....");
        enderecoRepository.list().remove(endereco);
        emailService.emailDeleteEndereco(objectMapper.convertValue(endereco,EnderecoDTO.class),objectMapper.convertValue(pessoa,PessoaDTO.class));
        log.info("Endereço deletado!");
    }

    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        Endereco endereco = enderecoRepository.list().stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Endereço não cadastrado"));
        return endereco;
    }
}
