package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.RelatorioPessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {
    //Query Methods
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    //JPQL ou HQL
    @Query("select p " +
            " from PESSOA p " +
            "where p.cpf = ?1") //p.cpf (igual atributo cpf da PessoaEntity) PESSOA igual @Entity)
    List<PessoaEntity> listPessoasByCpf (String cpf);
    @Query("select p " +
            " from PESSOA p " +
            "where p.cpf = :cpf")
    List<PessoaEntity> listPessoasByCpfParam (@Param("cpf") String cpf);
    @Query("select p " +
            " from PESSOA p " +
            " join p.contatos cont " +
            "where cont.tipoContato = :tipoContato")
    List<PessoaEntity> listPessoasByTipoContato (@Param("tipoContato")TipoContato tipoContato);
    @Query("select p,c,e,pe " +
            " from PESSOA p " +
            " join p.contatos c " +
            " join p.enderecos e " +
            " join p.pet pe " +
            "where p.idPessoa = :idPessoa ")
    List<PessoaEntity> listPessoaCompleto (@Param("idPessoa")Integer idPessoa);
    @Query("select p,c,e,pe " +
            " from PESSOA p " +
            " join p.contatos c " +
            " join p.enderecos e " +
            " join p.pet pe ")
    List<PessoaEntity> listPessoaCompletoSemId ();
    @Query("select new br.com.dbc.vemser.pessoaapi.dto.RelatorioPessoaDTO(" +
            "p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "pet.nome) " +
            "from PESSOA p " +
            "left join p.contatos c " +
            "left join p.enderecos e " +
            "left join p.pet pet " +
            "where p.idPessoa = :idPessoa")
    List<RelatorioPessoaDTO> relatorioPessoa(@Param("idPessoa") Integer idPessoa);
}
