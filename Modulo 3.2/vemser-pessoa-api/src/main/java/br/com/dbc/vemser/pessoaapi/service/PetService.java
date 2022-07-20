package br.com.dbc.vemser.pessoaapi.service;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
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
        //pessoaService.findById(id).setPet(petEntity);
        petRepository.save(petEntity);
        return objectMapper.convertValue(petEntity,PetDTO.class);
    }

    public List<PetDTO> list(){
        return petRepository.findAll().stream()
                .map(petEntity -> objectMapper.convertValue(petEntity,PetDTO.class))
                .collect(Collectors.toList());
    }

    public PetDTO update(Integer id,
                             PetCreateDTO petAtualizar) throws RegraDeNegocioException {
        pessoaService.findById(petAtualizar.getIdPessoa());
        PetEntity petEntityRecuperado = findById(id);
        PessoaEntity pessoaEntity = petEntityRecuperado.getPessoa();
        pessoaEntity.setPet(null);
        PessoaEntity pessoaRecuperada = pessoaService.findById(petAtualizar.getIdPessoa());
        petEntityRecuperado.setIdPet(id);
        objectMapper.convertValue(petAtualizar, PetEntity.class);
        petEntityRecuperado.setNome(petAtualizar.getNome());
        petEntityRecuperado.setTipo(petAtualizar.getTipo());
        petEntityRecuperado.setPessoa(pessoaRecuperada);
        pessoaRecuperada.setPet(petEntityRecuperado);
        pessoaService.save(pessoaRecuperada);
        if (!pessoaRecuperada.getIdPessoa().equals(pessoaEntity.getIdPessoa())){
            pessoaService.save(pessoaEntity);
        }
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
