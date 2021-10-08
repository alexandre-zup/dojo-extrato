package br.com.zup.edu.dojo.extrato.kafka;

import br.com.zup.edu.dojo.extrato.transacao.Transacao;
import br.com.zup.edu.dojo.extrato.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TransacaoRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void consume(TransacaoRequest request) {
        /*Instanciar e persistir transacao*/

        Transacao transacao = request.toModel();

        repository.save(transacao);

        log.info("Registrada transação: " + transacao.getId());

    }

}
