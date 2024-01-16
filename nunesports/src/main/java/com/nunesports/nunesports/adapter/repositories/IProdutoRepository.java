package com.nunesports.nunesports.adapter.repositories;

import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoJpaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoJpaMapper, UUID> {
    boolean existsByNome(String nome);

    Page<ProdutoJpaMapper> findAll(Pageable pageable);
}
