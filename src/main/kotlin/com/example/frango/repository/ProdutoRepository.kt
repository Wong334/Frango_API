package com.example.frango.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.frango.model.Produto

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {
    fun findByNome(nome: String): Produto?
}
