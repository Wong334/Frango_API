package com.example.frango.converters

import com.example.frango.dto.ProdutoDTO
import com.example.frango.dto.ProdutoResponseDTO
import com.example.frango.model.Produto
import org.springframework.stereotype.Component

@Component
class ProdutoConverter {
    fun toProdutoResponseDTO(produto: Produto): ProdutoResponseDTO {
        return ProdutoResponseDTO(
            id = produto.id,
            nome = produto.nome,
            tipo = produto.tipo,
            preco = produto.preco
        )
    }

    fun toProduto(dto: ProdutoDTO): Produto {
        return Produto(
            nome = dto.nome,
            tipo = dto.tipo,
            preco = dto.preco
        )
    }
}
