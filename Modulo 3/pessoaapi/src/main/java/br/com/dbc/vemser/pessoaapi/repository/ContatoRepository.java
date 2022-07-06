package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.controller.PessoaController;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    PessoaRepository pessoaRepository = new PessoaRepository();
    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, "COMERCIAL", "12345678910", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, "RESIDENCIAL", "6756638848", "telefone"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, "RESIDENCIAL", "8857636749", "telefone"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, "COMERCIAL", "788476366443", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, "PESSOAL", "775884773994", "whatsapp"));
    }

    public Contato create(Contato contato) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(()-> new Exception("Id não válido"));

        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
