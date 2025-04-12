package com.dhiego.meu_site.controller;

import com.dhiego.meu_site.dto.OperadorasAtivasDTO;
import com.dhiego.meu_site.services.OperadorasativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BuscaController {
    private final OperadorasativaService oaService;

    @PostMapping("/busca")
    public ResponseEntity<?> buscar(@RequestBody String termo){
        List<OperadorasAtivasDTO> resultados = oaService.buscarOperadoras(termo);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

}
