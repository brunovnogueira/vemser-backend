package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {
    @Query("select e " +
            " from ENDERECO_PESSOA e " +
            "where e.pais = ?1")
    List<EnderecoEntity> listByPais(String pais);
    @Query("select e " +
            "from ENDERECO_PESSOA e")
    Page<EnderecoEntity> listByCepPage(Pageable pageable);

    @Query("select e " +
            " from ENDERECO_PESSOA e " +
            "where e.pais = ?1")
    Page<EnderecoEntity> listByPaisPage(Pageable pageable, String pais);
}
