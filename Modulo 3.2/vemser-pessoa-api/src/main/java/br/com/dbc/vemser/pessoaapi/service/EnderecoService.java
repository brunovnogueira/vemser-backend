package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTOCreate;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
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
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    
    public List<EnderecoDTO> listPorId(Integer id) throws RegraDeNegocioException {
        findById(id);
        return enderecoRepository.findAll().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(id)).map(enderecoEntity -> objectMapper.convertValue(enderecoEntity,EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        return enderecoRepository.findAll().stream()
                .filter(enderecoEntity -> enderecoEntity.getPessoas().contains(pessoaEntity))
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoDTOCreate endereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        PessoaEntity pessoaEntityValida = pessoaService.findById(idPessoa);
        PessoaDTO pessoaValidaDTO = objectMapper.convertValue(pessoaEntityValida, PessoaDTO.class);
        log.info("Criando endereço....");
        EnderecoEntity enderecoEntityCriado = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoCriadoDTO = objectMapper.convertValue(enderecoEntityCriado,EnderecoDTO.class);
        log.info("Endereço criado!");
        return enderecoCriadoDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoDTOCreate enderecoAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityValida = pessoaService.findById(id);
        PessoaDTO pessoaValidaDTO = objectMapper.convertValue(pessoaEntityValida,PessoaDTO.class);
        EnderecoEntity enderecoEntityRecuperado = findById(id);
        objectMapper.convertValue(enderecoAtualizar, EnderecoEntity.class);
        log.info("Atualizando endereço....");
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());
        EnderecoDTO enderecoRecuperadoDTO = objectMapper.convertValue(enderecoRepository.save(enderecoEntityRecuperado),EnderecoDTO.class);
        log.info("Endereço atualizado!");
        emailService.emailAtualizacaoEndereco(enderecoRecuperadoDTO,pessoaValidaDTO);
        return enderecoRecuperadoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = findById(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity,EnderecoDTO.class);
        log.info("Deletendo endereço....");
        enderecoRepository.delete(enderecoEntity);
        log.info("Endereço deletado!");
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = enderecoRepository.findAll().stream()
                .filter(enderecoEntity1 -> enderecoEntity1.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Endereço não cadastrado"));
        return enderecoEntity;
    }
}
