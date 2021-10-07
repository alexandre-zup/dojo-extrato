package br.com.zup.edu.dojo.extrato.extrato;

import br.com.zup.edu.dojo.extrato.transacao.Transacao;
import br.com.zup.edu.dojo.extrato.transacao.TransacaoRepository;
import br.com.zup.edu.dojo.extrato.transacao.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conta")
public class ExtratoController {

    @Autowired
    TransacaoRepository repository;

    @GetMapping(value = "/{idCliente}/extrato")
    public ResponseEntity<?> consulta(@PathVariable @Valid UUID idCliente,
                                      @PageableDefault(
                                              sort = "efetuadaEm",
                                              direction = Sort.Direction.DESC,
                                              size = 20) Pageable pageable) {

        Page<Transacao> transacoes = repository.findAllByIdCliente(idCliente, pageable);

        return ResponseEntity.ok(transacoes.get().map(TransacaoResponse::new).collect(Collectors.toList()));

    }
}
