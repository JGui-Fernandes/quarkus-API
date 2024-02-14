package com.joaofernandes;

import java.math.BigDecimal;

public record CadastraProdutoRequest(
        String nome,
        BigDecimal valor
) {
    public CadastraProdutoRequest(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
