package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;
    public ContatoService(){

    }

    public Contato create(Contato contato, Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaValida = pessoaService.findById(idPessoa);
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(contato);
    }
    public List<Contato> list(){
        return contatoRepository.list();
    }
    public Contato update(Integer id,
                         Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contato = findById(id);
        contatoRepository.list().remove(contato);
    }

    public List<Contato> listByIdPessoa(Integer id) {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato findById(Integer idContato) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(()->new RegraDeNegocioException("Contato não cadastrado"));
        return contatoRecuperado;
    }
}
