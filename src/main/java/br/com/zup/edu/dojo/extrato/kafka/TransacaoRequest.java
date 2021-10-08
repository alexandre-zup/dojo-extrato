package br.com.zup.edu.dojo.extrato.kafka;

import br.com.zup.edu.dojo.extrato.transacao.TipoTransacao;
import br.com.zup.edu.dojo.extrato.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoRequest {

    private TipoTransacao tipoTransacao;
    private BigDecimal valor;
    private LocalDateTime efetuadaEm;
    private UUID idCliente;
    private String numeroConta;

    @Deprecated
    public TransacaoRequest() {
    }

    public TransacaoRequest(TipoTransacao tipoTransacao, BigDecimal valor, LocalDateTime efetuadaEm, UUID idCliente, String numeroConta) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.efetuadaEm = efetuadaEm;
        this.idCliente = idCliente;
        this.numeroConta = numeroConta;
    }

    public Transacao toModel() {
        return new Transacao(
                this.tipoTransacao,
                this.valor,
                this.efetuadaEm,
                this.idCliente,
                this.numeroConta
        );
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
