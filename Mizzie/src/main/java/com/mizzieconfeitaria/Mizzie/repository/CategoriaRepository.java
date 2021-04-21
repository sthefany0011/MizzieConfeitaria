package com.mizzieconfeitaria.Mizzie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mizzieconfeitaria.Mizzie.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	@Query(value= "select * from tb_categoria\r\n"
			+ "where nome = :nome", nativeQuery =true)	
	public List<Categoria> buscaPorNome(@Param("nome") String nome );
}