package api.com.tchakabum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.com.tchakabum.model.ProdutoVO;
import api.com.tchakabum.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoVO criarProduto(@RequestBody ProdutoVO produtoVO){
        return produtoService.criarProduto(produtoVO);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoVO>> listarProduto() {
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoService.getProdutos());
    }
    
    @GetMapping("/{id}")
    public ProdutoVO buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void editarProduto(@RequestBody ProdutoVO produto, @PathVariable("id") Long id) {
        produtoService.alterarProduto(produto, id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") Long id) {
        produtoService.excluirProduto(id);
    }

}
