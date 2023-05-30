package api.com.tchakabum.service;

import api.com.tchakabum.entity.ProdutoEntity;
import api.com.tchakabum.model.ProdutoVO;
import api.com.tchakabum.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void criarProduto(ProdutoVO produtoVO) {
        ProdutoEntity produtoEntity = mapProdutoVOParaEntity(produtoVO);
        produtoRepository.save(produtoEntity);
    }

    @Override
    public List<ProdutoVO> getProdutos() {
        List<ProdutoVO> listaProdutos = new ArrayList<>();
        produtoRepository.findAll().forEach(item->{
            listaProdutos.add(mapProdutoEntityParaVO(item));
        });
        return listaProdutos;
    }

    @Override
    public void alterarProduto(ProdutoVO produtoVO, Long postId) {

        produtoRepository.findById(postId).ifPresentOrElse(item->{
            item.setValorProduto(produtoVO.getValorProduto());
            item.setCategoriaProduto(produtoVO.getCategoriaProduto());
            item.setPromocaoProduto(produtoVO.getPromocaoProduto());
            item.setNomeProduto(produtoVO.getNomeProduto());
            item.setDescricaoProduto(produtoVO.getDescricaoProduto());
            item.setQuantidadeProduto(produtoVO.getQuantidadeProduto());

            produtoRepository.save(item);

        }, ()->{
            throw new NoSuchElementException();
        });
    }

    @Override
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoVO mapProdutoEntityParaVO(ProdutoEntity produtoEntity) {

        return ProdutoVO.builder()
                .valorProduto(produtoEntity.getValorProduto())
                .quantidadeProduto(produtoEntity.getQuantidadeProduto())
                .promocaoProduto(produtoEntity.getPromocaoProduto())
                .categoriaProduto(produtoEntity.getCategoriaProduto())
                .descricaoProduto(produtoEntity.getDescricaoProduto())
                .nomeProduto(produtoEntity.getNomeProduto()).build();
    }

    private ProdutoEntity mapProdutoVOParaEntity(ProdutoVO produtoVO) {

        ProdutoEntity produtoEntity = new ProdutoEntity();
/*        produtoRepository.findById(produtoVO.getForncedorId()).ifPresentOrElse(item->{
            produtoEntity.setFornecedorProdutoId(item.getFornecedorProdutoId());
        }, ()->{
            throw new RuntimeException();
        });
*/
        produtoEntity.setNomeProduto(produtoVO.getNomeProduto());
        produtoEntity.setPromocaoProduto(produtoVO.getPromocaoProduto());
        produtoEntity.setValorProduto(produtoVO.getValorProduto());
        produtoEntity.setQuantidadeProduto(produtoVO.getQuantidadeProduto());
        produtoEntity.setCategoriaProduto(produtoVO.getCategoriaProduto());
        produtoEntity.setDescricaoProduto(produtoVO.getDescricaoProduto());

        return produtoEntity;
    }
}
