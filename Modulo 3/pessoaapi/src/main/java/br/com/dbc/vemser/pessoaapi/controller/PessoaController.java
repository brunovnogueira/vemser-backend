package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertyReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTOcreate;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {
    @Autowired //não preciso mais instanciar um new PessoaService()
    private PessoaService pessoaService;

//    @Autowired
//    private PropertyReader propertyReader;

//    //Modelo novo (depreciamento do AutoWired)
//    private final PessoaService pessoaService;
//    public PessoaController(PessoaService pessoaService) {
//        this.pessoaService = pessoaService;
//    }


    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

//    @GetMapping("/ambiente")
//    public String propertyReader(){
//        return propertyReader.getAmbiente();
//    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaDTOcreate pessoa){
        return ResponseEntity.ok(pessoaService.create(pessoa));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK)
    }

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/{nome}") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@PathVariable("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaDTOcreate pessoaAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}
