package com.example.lojagames.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lojagames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	Object findAllByNomeContainingIgnoreCase(String nome);

}
