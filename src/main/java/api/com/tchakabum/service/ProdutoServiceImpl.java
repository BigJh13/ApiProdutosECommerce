package api.com.tchakabum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.com.tchakabum.entity.ProdutoEntity;
import api.com.tchakabum.exception.NaoEncontradoException;
import api.com.tchakabum.model.ProdutoVO;
import api.com.tchakabum.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoVO criarProduto(ProdutoVO produtoVO) {
        ProdutoEntity produtoEntity = mapProdutoVOParaEntity(produtoVO);
        produtoEntity = produtoRepository.save(produtoEntity);
        return mapProdutoEntityParaVO(produtoEntity);
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
	public ProdutoVO buscarPorId(Long id) {
    	ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Nenhum produto foi encontrado"));
    	return mapProdutoEntityParaVO(produto);
	}

    @Override
    public void alterarProduto(ProdutoVO produtoVO, Long postId) {

    	produtoRepository.findById(postId).ifPresentOrElse(item->{
    		item.setValor(produtoVO.getValor());
    		item.setCategoria(produtoVO.getCategoria());
    		item.setPromocao(produtoVO.getPromocao());
    		item.setNome(produtoVO.getNome());
    		item.setDescricao(produtoVO.getDescricao());
    		item.setQuantidade(produtoVO.getQuantidade());

    		produtoRepository.save(item);

    	}, () -> { throw new NaoEncontradoException("Nenhum produto foi encontrado");
    	});
    }

    @Override
    public void excluirProduto(Long id) {
    	ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Nenhum produto foi encontrado"));
        produtoRepository.delete(produto);
    }

    private ProdutoVO mapProdutoEntityParaVO(ProdutoEntity produtoEntity) {

        return ProdutoVO.builder()
        		.id(produtoEntity.getId())
                .valor(produtoEntity.getValor())
                .quantidade(produtoEntity.getQuantidade())
                .promocao(produtoEntity.getPromocao())
                .categoria(produtoEntity.getCategoria())
                .descricao(produtoEntity.getDescricao())
                .nome(produtoEntity.getNome()).build();
    }

    private ProdutoEntity mapProdutoVOParaEntity(ProdutoVO produtoVO) {

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(produtoVO.getId());
        produtoEntity.setNome(produtoVO.getNome());
        produtoEntity.setPromocao(produtoVO.getPromocao());
        produtoEntity.setValor(produtoVO.getValor());
        produtoEntity.setQuantidade(produtoVO.getQuantidade());
        produtoEntity.setCategoria(produtoVO.getCategoria());
        produtoEntity.setDescricao(produtoVO.getDescricao());

        return produtoEntity;
    }

	
}
