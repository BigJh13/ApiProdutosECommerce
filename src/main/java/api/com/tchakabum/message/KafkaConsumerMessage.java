package api.com.tchakabum.message;

import api.com.tchakabum.model.ProdutoVO;
import api.com.tchakabum.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private ProdutoService produtoService;

    @KafkaListener(topics = "produto-post-topic", groupId = "store-posts-group")
    public void listening(ProdutoVO produtoVO){
        LOG.info("informação de novo post recebido {}");
        produtoService.criarProduto(produtoVO);
    }
}
