package br.com.zup.edu.dojo.extrato.transacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @PastOrPresent
    private LocalDateTime efetuadaEm;

    @NotNull
    private UUID idCliente;

    @NotBlank
    private String numeroConta;

    @Deprecated
    public Transacao() {
    }

    public Transacao(TipoTransacao tipoTransacao, BigDecimal valor, LocalDateTime efetuadaEm, UUID idCliente, String numeroConta) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.efetuadaEm = efetuadaEm;
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
    }

    public Long getId() {
        return id;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetuadaEm() {
        return efetuadaEm;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
