package br.com.zup.edu.dojo.extrato.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findTop20ByIdClienteOrderByEfetuadaEmDesc(UUID idCliente);

    Page<Transacao> findAllByIdCliente(UUID idCliente, Pageable pageable);
}
