package com.dhiego.meu_site.dto;

import com.dhiego.meu_site.database.entity.Operadorasativa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class OperadorasAtivasDTO {
    private String nome;
    private String registroANS;
    private String cnpj;
    private String cidade;
    private String UF;

    public OperadorasAtivasDTO(Operadorasativa oa) {
        this.nome = oa.getRazaoSocial();
        this.cnpj = String.valueOf(oa.getCnpj());
        this.registroANS = String.valueOf(oa.getRegistroAns());
        this.cidade = oa.getCidade();
        this.UF = oa.getUf();
    }
}