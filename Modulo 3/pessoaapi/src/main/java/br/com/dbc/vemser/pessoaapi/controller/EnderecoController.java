package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list(){
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listPorId(@PathVariable("idEndereco") Integer id){
        return enderecoService.listPorId(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listPorIdPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listPorIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid Endereco endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(idEndereco, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
