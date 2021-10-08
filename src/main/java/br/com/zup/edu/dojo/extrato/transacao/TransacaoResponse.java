package br.com.zup.edu.dojo.extrato.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponse {

    @JsonProperty
    private TipoTransacao operacao;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private LocalDateTime efetuadaEm;
    @JsonProperty
    private UUID idCliente;
    @JsonProperty
    private String numeroConta;

    @Deprecated
    public TransacaoResponse(){}

    public TransacaoResponse(Transacao transacao) {
        this.operacao = transacao.getTipoTransacao();
        this.valor = transacao.getValor();
        this.efetuadaEm = transacao.getEfetuadaEm();
        this.idCliente = transacao.getIdCliente();
        this.numeroConta = transacao.getNumeroConta();
    }

}
