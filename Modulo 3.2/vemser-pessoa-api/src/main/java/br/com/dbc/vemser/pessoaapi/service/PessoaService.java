package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;
    public PessoaService(){

    }

    public PessoaDTO create(PessoaDTOCreate pessoa){
        log.info("Criando pessoa...");
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info("Pessoa criada!");
        emailService.sendEmailPessoaCadastrada(pessoaDTO);
        return pessoaDTO;
    }

    public List<PessoaDTO> list(){

        return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity,PessoaDTO.class)).collect(Collectors.toList());

    }

    public List<PessoaDTO> listPessoaEndereco(Integer id){
        if (id != null){
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listPessoaContato(Integer id){
        if (id != null){
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }
    public List<PessoaDTO> listPessoaCompleta(Integer id){
        if (id != null){
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setPets(objectMapper.convertValue(pessoaEntity.getPet(),PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setPets(objectMapper.convertValue(pessoaEntity.getPet(),PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }
    public List<PessoaDTO> listPessoaPets(Integer id) {
        if (id != null){
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setPets(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
                        pessoaDTO.setPets(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<RelatorioPessoaDTO> relatorioPessoa(Integer id){
        return pessoaRepository.relatorioPessoa(id);
    }

    public PessoaDTO update(Integer id,
                            PessoaDTOCreate pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = findById(id);
        log.info("Atualizando pessoa...");
        pessoaEntityRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaEntityRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        log.info("Pessoa atualizada!");
        return objectMapper.convertValue(pessoaRepository.save(pessoaEntityRecuperada),PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);
        log.info("Deletando pessoa....");
        pessoaRepository.delete(pessoaEntity);
        log.info("Pessoa deletada!");
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class)).collect(Collectors.toList());
    }

    public PessoaEntity save(PessoaEntity pessoaEntity){
        return this.pessoaRepository.save(pessoaEntity);
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaEntityRecuperada;
    }
}
