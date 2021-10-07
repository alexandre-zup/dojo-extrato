package br.com.zup.edu.dojo.extrato.extrato;

import br.com.zup.edu.dojo.extrato.transacao.TransacaoRepository;
import br.com.zup.edu.dojo.extrato.transacao.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/conta")
public class ExtratoController {

    @Autowired
    TransacaoRepository repository;

    @GetMapping(value = "/{idCliente}/extrato")
    public ResponseEntity<?> consulta(@PathVariable @Valid UUID idCliente) {
        List<TransacaoResponse> transacoes = repository.findTop20ByIdClienteOrderByEfetuadaEmDesc(idCliente);
        return ResponseEntity.ok().body(transacoes);
    }
}
