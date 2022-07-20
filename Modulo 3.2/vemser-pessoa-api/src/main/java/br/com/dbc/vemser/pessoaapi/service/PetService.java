package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTOCreate;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    PessoaService pessoaService;

    public PetDTO create(PetCreateDTO pet, Integer id) throws RegraDeNegocioException {
        PetEntity petEntity = objectMapper.convertValue(pet, PetEntity.class);
        petEntity.setPessoa(pessoaService.findById(id));
        pessoaService.findById(id).setPet(petEntity);
        petRepository.save(petEntity);
        pessoaService.findById(id).setPet(petEntity);
        return objectMapper.convertValue(petRepository.save(petEntity),PetDTO.class);
    }

    public List<PetDTO> list(){
        return petRepository.findAll().stream().map(petEntity -> objectMapper.convertValue(petEntity,PetDTO.class)).collect(Collectors.toList());
    }

    public PetDTO update(Integer id,
                             PetCreateDTO petAtualizar) throws RegraDeNegocioException {
        pessoaService.findById(petAtualizar.getIdPessoa());
        PetEntity petEntityRecuperado = findById(id);
        petEntityRecuperado.setIdPet(id);
        objectMapper.convertValue(petAtualizar, PetEntity.class);
        petEntityRecuperado.setNome(petAtualizar.getNome());
        petEntityRecuperado.setTipo(petAtualizar.getTipo());
        petEntityRecuperado.setIdPessoa(petAtualizar.getIdPessoa());
        return objectMapper.convertValue(petRepository.save(petEntityRecuperado),PetDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PetEntity petEntity = findById(id);
        petRepository.delete(petEntity);
    }

    public PetEntity findById(Integer idPet) throws RegraDeNegocioException {
        return petRepository.findAll().stream()
                .filter(petEntity -> petEntity.getIdPet().equals(idPet))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Pet não cadastrado"));
    }
}
