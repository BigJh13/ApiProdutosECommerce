package api.com.tchakabum.controller;

import api.com.tchakabum.model.ProdutoVO;
import api.com.tchakabum.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity criarProduto(@RequestBody ProdutoVO produtoVO){
        produtoService.criarProduto(produtoVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ProdutoVO>> listarProduto() {
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoService.getProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity editarProduto(@RequestBody ProdutoVO produto, @PathVariable("id") Long id) {
        produtoService.alterarProduto(produto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable("id") Long id) {
        produtoService.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
