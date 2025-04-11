package com.dhiego.meu_site.database.repository;

import com.dhiego.meu_site.database.entity.Operadorasativa;
import com.dhiego.meu_site.database.entity.OperadorasativaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OperadorasativasRepository extends JpaRepository<Operadorasativa, OperadorasativaId> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM operadorasativas " +
            "WHERE LOWER(razao_social) LIKE LOWER(CONCAT('%', :termo, '%'))" +
            "OR LOWER(nome_fantasia) LIKE LOWER(CONCAT('%', :termo, '%'))" +
            "LIMIT 10", nativeQuery = true)
    List<Operadorasativa> buscarPorTermo(@Param("termo") String termo);



}
