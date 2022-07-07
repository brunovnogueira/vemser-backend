package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Endereco create(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
