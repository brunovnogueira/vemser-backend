package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTOCreate;
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

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaEntityRecuperada;
    }
}
