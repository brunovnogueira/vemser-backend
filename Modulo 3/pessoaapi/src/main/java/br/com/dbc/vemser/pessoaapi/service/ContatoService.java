package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public ContatoService(){

    }

    public Contato create(Contato contato, Integer idPessoa) throws Exception{
        boolean pessoaValida = pessoaRepository.list().stream()
                .anyMatch(id -> id.getIdPessoa().equals(idPessoa));
        if (pessoaValida){
            contato.setIdPessoa(idPessoa);
            return contatoRepository.create(contato);
        }else {
            throw new Exception("idPessoa inválido.");
        }
    }
    public List<Contato> list(){
        return contatoRepository.list();
    }
    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer id) {
        return contatoRepository.listByIdPessoa(id);
    }
}
