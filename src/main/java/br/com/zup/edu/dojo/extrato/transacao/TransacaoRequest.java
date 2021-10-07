package br.com.zup.edu.dojo.extrato.transacao;

import br.com.zup.edu.dojo.extrato.transacao.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoRequest {

    private TipoOperacao tipoOperacao;
    private BigDecimal valor;
    private LocalDateTime efetuadaEm;
    private UUID idCliente;
    private String numeroDaConta;

    @Deprecated
    public TransacaoRequest() {
    }

    public TransacaoRequest(TipoOperacao tipoOperacao, BigDecimal valor, LocalDateTime efetuadaEm, UUID idCliente, String numeroDaConta) {
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.efetuadaEm = efetuadaEm;
        this.idCliente = idCliente;
        this.numeroDaConta = numeroDaConta;
    }

    public Transacao toModel() {
        return new Transacao(
                this.tipoOperacao,
                this.valor,
                this.efetuadaEm,
                this.idCliente,
                this.numeroDaConta
        );
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
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
