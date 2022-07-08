package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PessoaService pessoaService;

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public List<Endereco> listPorId(Integer id){
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listPorIdPessoa(Integer id){
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws RegraDeNegocioException {
        Pessoa pessoaValida = pessoaService.findById(idPessoa);
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = findById(id);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco endereco = findById(id);
        enderecoRepository.list().remove(endereco);
    }

    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        Endereco endereco = enderecoRepository.list().stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Endereço não cadastrado"));
        return endereco;
    }
}
