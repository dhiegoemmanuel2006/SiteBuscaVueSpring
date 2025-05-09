package com.dhiego.meu_site.controller;

import com.dhiego.meu_site.dto.OperadorasAtivasDTO;
import com.dhiego.meu_site.services.OperadorasativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "OperadorasAtivas", description = "Operação de busca das operadoras ativas")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BuscaController {
    private final OperadorasativaService oaService;

    @Operation(
            summary = "Obter 10 usuário pelo Nome ou Razão social",
            description = "Retorna 10 Operadoras Ativas com base nos dados da ANS",
            tags = {"OperadorasAtivas"},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Operadoras encontradas",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "[{\"nome\": \"Unimed Rio Verde\", \"registroANS\": \"123456\", " +
                                                    "\"cnpj\": \"12345678901234\", \"cidade\": \"Rio Verde\", \"UF\": \"GO\"}]"
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Termo de busca inválido"),
                    @ApiResponse(responseCode = "204", description = "Nenhuma operadora encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor / banco de dados")
            }
    )
    @PostMapping("/busca")
    public ResponseEntity<List<OperadorasAtivasDTO>> buscar(@Parameter(description = "O termo que fará a busca", required = true, example = "{\"termo\":\"unimed\"}") @RequestParam String termo){
        List<OperadorasAtivasDTO> resultados = oaService.buscarOperadoras(termo);

        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

}
