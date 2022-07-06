package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){

    }

    public Pessoa create(Pessoa pessoa) throws Exception {
        boolean nomeBranco = StringUtils.isBlank(pessoa.getNome());
        boolean pessoaExiste = ObjectUtils.isEmpty(pessoa);
        int cpf = StringUtils.length(pessoa.getCpf());
        if (!nomeBranco && !pessoaExiste && cpf==11){
            return pessoaRepository.create(pessoa);
        }
        throw new Exception("Dados inválidos");
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
