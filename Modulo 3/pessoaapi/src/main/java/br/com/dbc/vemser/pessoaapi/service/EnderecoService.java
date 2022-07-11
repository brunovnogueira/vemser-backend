package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTOcreate;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
    public List<EnderecoDTO> list(){
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList());
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

    public EnderecoDTO create(Integer idPessoa, EnderecoDTOcreate endereco) throws RegraDeNegocioException {
        Pessoa pessoaValida = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco,Endereco.class);
        log.info("Criando endereço....");
        Endereco enderecoCriado = enderecoRepository.create(enderecoEntity);
        enderecoEntity.setIdPessoa(idPessoa);
        log.info("Endereço criado!");
        return objectMapper.convertValue(enderecoCriado,EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoDTOcreate enderecoAtualizar) throws RegraDeNegocioException {
        pessoaService.findById(id);
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
        return objectMapper.convertValue(enderecoRecuperado,EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco endereco = findById(id);
        log.info("Deletendo endereço....");
        enderecoRepository.list().remove(endereco);
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
