package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTOcreate;
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
    public List<EnderecoDTO> list(){
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listPorId(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        return enderecoService.listPorId(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listPorIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return enderecoService.listPorIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid EnderecoDTOcreate endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid EnderecoDTOcreate endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(idEndereco, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
