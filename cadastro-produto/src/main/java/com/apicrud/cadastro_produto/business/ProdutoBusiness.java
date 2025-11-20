package com.apicrud.cadastro_produto.business;

import com.apicrud.cadastro_produto.infrastructure.entities.Produto;
import com.apicrud.cadastro_produto.infrastructure.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBusiness {

    private final ProdutoRepository repository;

    public ProdutoBusiness(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Produto produto){
        repository.saveAndFlush(produto);
    }

    public Produto buscarProdutoPorCodigo(String codigo){
        return repository.findByCode(codigo).orElseThrow(()-> new RuntimeException("Produto não encontrado!")); }

    public void deletarProdutoPorCodigo(String codigo){
        repository.deleteByCode(codigo);
    }

    public void atualizarProdutoPorId(Integer id, Produto produto) {

        Produto produtoEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        assert Produto.builder() != null;
        Produto produtoAtualizado = Produto.builder()
                .id(produtoEntity.getId())
                .descricao(produto.getDescricao() != null ? produto.getDescricao() : produtoEntity.getDescricao())
                .tamanho(produto.getTamanho() != null ? produto.getTamanho() : produtoEntity.getTamanho())
                .codigo(produto.getCodigo() != null ? produto.getCodigo() : produtoEntity.getCodigo())
                .build();

        repository.saveAndFlush(produtoAtualizado);
    }

}
