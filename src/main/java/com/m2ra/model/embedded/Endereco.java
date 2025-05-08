package com.m2ra.model.embedded;

import com.m2ra.model.enums.EnumUF;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    @Column(name="end_cep")
    private String cep;

    @Column(name="end_logradouro")
    private String logradouro;

    @Column(name="end_numero")
    private String numero;

    @Column(name="end_complemento")
    private String complemento;

    @Column(name="end_bairro")
    private String bairro;

    @Column(name="end_cidade")
    private String cidade;

    @Column(name="end_uf")
    @Enumerated(EnumType.STRING)
    private EnumUF uf;
}
