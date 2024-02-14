package com.joaofernandes;

import java.math.BigDecimal;

public record AtualizaProdutoRequest(
        String nome,
        BigDecimal valor
) {
}
