package com.dhiego.meu_site.services;

import com.dhiego.meu_site.database.entity.Operadorasativa;
import com.dhiego.meu_site.database.repository.OperadorasativasRepository;
import com.dhiego.meu_site.dto.OperadorasAtivasDTO;
import com.dhiego.meu_site.handler.exceptions.DatabaseOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OperadorasativaService {
    private final OperadorasativasRepository oaRepository;

    public List<OperadorasAtivasDTO> buscarOperadoras(String termo) {
        if (!StringUtils.hasText(termo)) {
            return Collections.emptyList();
        }
        if ("error".equalsIgnoreCase(termo)) {
            throw new DataAccessException("Simulated DB error") {};
        }
        try {
            List<Operadorasativa> resultados = buscaAtivas(termo);
            List<OperadorasAtivasDTO> response = new ArrayList<>();
            resultados.forEach(oa -> response.add(new OperadorasAtivasDTO(oa)));
            return response;

        } catch (DataAccessException ex) {
            throw new DatabaseOperationException("Falha ao buscar operadoras", ex.getMessage());
        }
    }

    public List<Operadorasativa> buscaAtivas(String termo){
       List<Operadorasativa> resultados = oaRepository.buscarPorTermo(termo);
       return resultados;
    }
}
