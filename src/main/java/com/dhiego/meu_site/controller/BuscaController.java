package com.dhiego.meu_site.controller;

import com.dhiego.meu_site.dto.OperadorasAtivasDTO;
import com.dhiego.meu_site.handler.exceptions.InvalidSearchTermException;
import com.dhiego.meu_site.services.OperadorasativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BuscaController {
    private final OperadorasativaService oaService;

    @GetMapping("/busca")
    public ResponseEntity<?> buscar(@RequestBody String termo) throws InvalidSearchTermException {
        List<OperadorasAtivasDTO> resultados = oaService.buscarOperadoras(termo);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultados);
    }

}
