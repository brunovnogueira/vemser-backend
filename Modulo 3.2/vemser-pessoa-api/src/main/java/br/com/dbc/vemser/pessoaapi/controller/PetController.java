package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Validated
public class PetController {
    @Autowired
    private PetService petService;

    public PetController() {

    }

    @Operation(summary = "Listar pets", description = "Lista todos os pets do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pets"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<PetDTO> list(){
        return petService.list();
    }

    @Operation(summary = "Criar um novo pet", description = "Cria um novo pet no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable("idPessoa") Integer id, @RequestBody @Valid PetCreateDTO pet) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.create(pet, id));
    }

    @Operation(summary = "Atualizar pet", description = "Atualiza um pet do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id, @RequestBody @Valid PetCreateDTO petAtualizar) throws RegraDeNegocioException{
        return ResponseEntity.ok(petService.update(id,petAtualizar));
    }

    @Operation(summary = "Deletar pet", description = "Deleta um pet do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet deletado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
    }
}
