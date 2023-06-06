package api.com.tchakabum.service;

import java.util.List;

import api.com.tchakabum.model.ProdutoVO;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoService {

	ProdutoVO criarProduto(ProdutoVO produtoVO);

    List<ProdutoVO> getProdutos();
    
    ProdutoVO buscarPorId(Long id);

    void alterarProduto(ProdutoVO produtoVO, Long id);

    void excluirProduto(Long id);
}
