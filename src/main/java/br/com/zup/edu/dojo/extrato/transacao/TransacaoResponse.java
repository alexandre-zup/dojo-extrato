package br.com.zup.edu.dojo.extrato.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponse {

    @JsonProperty
    private TipoOperacao operacao;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private LocalDateTime efetuadaEm;
    @JsonProperty
    private UUID idCliente;
    @JsonProperty
    private String numeroDaConta;

    public TransacaoResponse(Transacao transacao) {
        this.operacao = transacao.getOperacao();
        this.valor = transacao.getValor();
        this.efetuadaEm = transacao.getEfetuadaEm();
        this.idCliente = transacao.getIdCliente();
        this.numeroDaConta = transacao.getNumeroDaConta();
    }

}
