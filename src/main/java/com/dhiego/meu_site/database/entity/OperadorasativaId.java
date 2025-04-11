package com.dhiego.meu_site.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OperadorasativaId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4492724596969309465L;

    @Column(name = "Registro_ANS", nullable = false, length = 20)
    private String registroAns;

    @Column(name = "CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OperadorasativaId entity = (OperadorasativaId) o;
        return Objects.equals(this.cnpj, entity.cnpj) &&
                Objects.equals(this.registroAns, entity.registroAns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, registroAns);
    }

}