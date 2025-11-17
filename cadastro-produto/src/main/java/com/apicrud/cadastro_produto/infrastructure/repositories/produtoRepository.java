package com.apicrud.cadastro_produto.infrastructure.repositories;
import com.apicrud.cadastro_produto.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface produtoRepository extends JpaRepository<Produto,Integer> {}
