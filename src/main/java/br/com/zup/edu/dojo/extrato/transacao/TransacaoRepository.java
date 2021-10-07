package br.com.zup.edu.dojo.extrato.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<TransacaoResponse> findTop20ByIdClienteOrderByEfetuadaEmDesc(UUID idCliente);
}
