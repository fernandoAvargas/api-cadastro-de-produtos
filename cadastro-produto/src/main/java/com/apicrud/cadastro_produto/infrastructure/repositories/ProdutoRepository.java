package com.apicrud.cadastro_produto.infrastructure.repositories;
import com.apicrud.cadastro_produto.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@SuppressWarnings("unused")
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    Optional<Produto> findByCode(String codigo);

    @Transactional
    void deleteByCode(String codigo);
  
}
