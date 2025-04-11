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
@Table(name = "OperadorasAtivas", schema = "dados_ans")
public class Operadorasativa {
    @EmbeddedId
    private OperadorasativaId id;

    @Column(name = "Razao_Social")
    private String razaoSocial;

    @Column(name = "Nome_Fantasia")
    private String nomeFantasia;

    @Column(name = "Modalidade", length = 50)
    private String modalidade;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "Numero", length = 20)
    private String numero;

    @Column(name = "Complemento")
    private String complemento;

    @Column(name = "Bairro", length = 100)
    private String bairro;

    @Column(name = "Cidade", length = 100)
    private String cidade;

    @Column(name = "UF", length = 2)
    private String uf;

    @Column(name = "CEP", length = 8)
    private String cep;

    @Column(name = "DDD", length = 2)
    private String ddd;

    @Column(name = "Telefone", length = 30)
    private String telefone;

    @Column(name = "Fax", length = 30)
    private String fax;

    @Column(name = "Endereco_Eletronico", length = 100)
    private String enderecoEletronico;

    @Column(name = "Representante", length = 100)
    private String representante;

    @Column(name = "Cargo_Representante", length = 100)
    private String cargoRepresentante;

    @Column(name = "Regiao_de_Comercializacao", length = 2)
    private String regiaoDeComercializacao;

    @Column(name = "Data_Registro_ANS", nullable = false)
    private LocalDate dataRegistroAns;

    public String getCnpj() {
        return id.getCnpj();
    }

    public String getRegistroAns() {
        return id.getRegistroAns();
    }
}