package api.com.tchakabum.service;

import api.com.tchakabum.model.ProdutoVO;

import java.util.List;

public interface ProdutoService {

    void criarProduto(ProdutoVO produtoVO);

    List<ProdutoVO> getProdutos();

    void alterarProduto(ProdutoVO produtoVO, Long id);

    void excluirProduto(Long id);
}
