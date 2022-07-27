package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorEntity> list(){
        return professorRepository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@RequestBody ProfessorEntity professorEntity){
        return professorRepository.save(professorEntity);
    }
}
