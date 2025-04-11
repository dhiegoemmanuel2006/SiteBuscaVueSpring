package com.dhiego.meu_site.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "operadorasativas")
public class Operadorasativa {
    @EmbeddedId
    private OperadorasativaId id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "modalidade", length = 50)
    private String modalidade;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero", length = 20)
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro", length = 100)
    private String bairro;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "ddd", length = 2)
    private String ddd;

    @Column(name = "telefone", length = 30)
    private String telefone;

    @Column(name = "fax", length = 30)
    private String fax;

    @Column(name = "endereco_eletronico", length = 100)
    private String enderecoEletronico;

    @Column(name = "representante", length = 100)
    private String representante;

    @Column(name = "cargo_representante", length = 100)
    private String cargoRepresentante;

    @Column(name = "regiao_de_comercializacao", length = 2)
    private String regiaoDeComercializacao;

    @Column(name = "data_registro_ans", nullable = false)
    private LocalDate dataRegistroAns;

    public char[] getCnpj() {
        return id.getCnpj().toCharArray();
    }

    public char[] getRegistroAns() {
        return id.getRegistroAns().toCharArray();
    }
}