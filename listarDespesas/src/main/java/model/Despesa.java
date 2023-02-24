package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Despesa {
    private long id = 0L;
    private final String descricao;
    private final LocalDate data;
    private final BigDecimal valor;
    private final Categoria categoria;

    public Despesa(long id, String descricao, LocalDate data, BigDecimal valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                ", categoria=" + categoria +
                '}';
    }
}
