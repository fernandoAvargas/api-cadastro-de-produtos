package com.apicrud.cadastro_produto.controller;

import com.apicrud.cadastro_produto.business.ProdutoBusiness;
import com.apicrud.cadastro_produto.infrastructure.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

private final ProdutoBusiness produtoBusiness;

    public ProdutoController(ProdutoBusiness produtoBusiness) {
        this.produtoBusiness = produtoBusiness;
    }

    @PostMapping
public ResponseEntity<Void>salvarProduto(@RequestBody Produto produto){
    produtoBusiness.salvarProduto(produto);
    return ResponseEntity.ok().build();
  }

  @GetMapping
    public ResponseEntity<Produto>busacarProdutoPorCodigo(@RequestParam String codigo){
        return ResponseEntity.ok(this.produtoBusiness.buscarProdutoPorCodigo(codigo));
  }

  @DeleteMapping
    public ResponseEntity<Void>deletarProdutoPorCodigo(@RequestParam String codigo){
        this.produtoBusiness.deletarProdutoPorCodigo(codigo);
        return ResponseEntity.ok().build();
  }

  @PutMapping
    public ResponseEntity<Void>tualizarProdutoPorId(@RequestParam Integer id, @RequestBody Produto produto){
        this.produtoBusiness.atualizarProdutoPorId(id,produto);
        return ResponseEntity.ok().build();
    }
}
