package com.dhiego.meu_site.database.repository;

import com.dhiego.meu_site.database.entity.Operadorasativa;
import com.dhiego.meu_site.database.entity.OperadorasativaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperadorasativasRepository extends JpaRepository<Operadorasativa, OperadorasativaId> {
    @Query(value = """
        SELECT * FROM `dados_ans`.`OperadorasAtivas`
        WHERE 
            MATCH(Razao_Social, Nome_Fantasia) 
            AGAINST(:termo IN BOOLEAN MODE)
        LIMIT 10""",
            nativeQuery = true)
    List<Operadorasativa> buscarPorTermo(@Param("termo") String termo);
}
