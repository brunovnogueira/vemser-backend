package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTOCreate;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;
    public ContatoService(){

    }

    public ContatoDTO create(ContatoDTOCreate contato, Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityValida = pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        log.info("Criando contato...");
        ContatoEntity contatoEntityCriado = contatoRepository.save(contatoEntity);
        contatoEntity.setIdPessoa(idPessoa);
        log.info("Contato criado!");
        return objectMapper.convertValue(contatoEntity,ContatoDTO.class);
    }
    public List<ContatoDTO> list(){
        return contatoRepository.findAll().stream().map(contatoEntity -> objectMapper.convertValue(contatoEntity,ContatoDTO.class)).collect(Collectors.toList());
    }
    public ContatoDTO update(Integer id,
                         ContatoDTOCreate contatoAtualizar) throws RegraDeNegocioException {
        pessoaService.findById(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoEntityRecuperado = findById(id);
        objectMapper.convertValue(contatoAtualizar, ContatoEntity.class);
        log.info("Atualizando contato...");
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());
        log.info("Contato atualizado!");
        return objectMapper.convertValue(contatoRepository.save(contatoEntityRecuperado),ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(id);
        log.info("Deletando contato....");
        contatoRepository.delete(contatoEntity);
        log.info("Contato deletado");
    }

    public List<ContatoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
        pessoaService.findById(id);
        return contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity,ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity contatoEntityRecuperado = contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Contato não cadastrado"));
        return contatoEntityRecuperado;
    }
}
