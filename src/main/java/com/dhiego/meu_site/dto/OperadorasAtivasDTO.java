package com.dhiego.meu_site.dto;

import com.dhiego.meu_site.database.entity.Operadorasativa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Operadoras Ativas DTO")
@AllArgsConstructor
@Data
public class OperadorasAtivasDTO {
    @Schema(description = "Razão Social da operadora", example = "unimed rio verde")
    private String nome;

    @Schema(description = "Registro ANS da operadora", example = "123456789",  pattern = "^\\\\d{14}$")
    private String registroANS;

    @Schema(description = "CNPJ da operadora", example = "12345678910", pattern = "^\\d+$")
    private String cnpj;

    @Schema(description = "Cidade onde a operadora fica", example = "São Paulo")
    private String cidade;

    @Schema(description = "UF onde a operadora fica", example = "SP")
    private String UF;

    public OperadorasAtivasDTO(Operadorasativa oa) {
        this.nome = oa.getRazaoSocial();
        this.cnpj = String.valueOf(oa.getCnpj());
        this.registroANS = String.valueOf(oa.getRegistroAns());
        this.cidade = oa.getCidade();
        this.UF = oa.getUf();
    }
}