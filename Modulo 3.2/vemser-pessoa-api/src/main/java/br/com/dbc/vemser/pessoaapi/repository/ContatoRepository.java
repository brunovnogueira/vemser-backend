package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity,Integer> {
    @Query("select c " +
            "from CONTATO c " +
            "where c.tipoContato = ?1")
    List<ContatoEntity> listByTipoContato(TipoContato tipoContato);

    @Query("select c " +
            "from CONTATO c" )
    Page<ContatoEntity> listPaginacao(Pageable pageable);
}
