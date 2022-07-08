package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    public ContatoController() {

    }

    //Listar Geral
    @GetMapping
    public List<Contato> list(){
        return contatoService.list();
    }

    //Listar por id pessoa
    @GetMapping("/{idPessoa}")
    public List<Contato> listByIdPessoa(@PathVariable("idPessoa") Integer id){
        return contatoService.listByIdPessoa(id);
    }

    //Adicionar
    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Contato contato) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.create(contato,idPessoa));
    }

    //Atualizar
    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id, @RequestBody @Valid Contato contatoAtualizar) throws RegraDeNegocioException{
        return ResponseEntity.ok(contatoService.update(id,contatoAtualizar));
    }

    //Deletar
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.delete(id);
    }
}
