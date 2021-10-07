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
    private TipoOperacao operacao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @PastOrPresent
    private LocalDateTime efetuadaEm;

    @NotNull
    private UUID idCliente;

    @NotBlank
    private String numeroDaConta;

    @Deprecated
    public Transacao() {
    }

    public Transacao(TipoOperacao operacao, BigDecimal valor, LocalDateTime efetuadaEm, UUID idCliente, String numeroDaConta) {
        this.operacao = operacao;
        this.valor = valor;
        this.efetuadaEm = efetuadaEm;
        this.idCliente = idCliente;
        this.numeroDaConta = numeroDaConta;
    }

    public Long getId() {
        return id;
    }

    public TipoOperacao getOperacao() {
        return operacao;
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

    public String getNumeroDaConta() {
        return numeroDaConta;
    }
}