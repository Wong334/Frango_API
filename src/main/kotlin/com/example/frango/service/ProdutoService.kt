package com.example.frango.service

import org.springframework.stereotype.Service
import com.example.frango.model.Produto
import com.example.frango.dto.ProdutoDTO
import com.example.frango.repository.ProdutoRepository
import com.example.frango.converters.ProdutoConverter
import com.example.frango.dto.ProdutoResponseDTO
import com.example.frango.exceptions.NotFoundException

private const val PRODUTO_NOT_FOUND_MESSAGE = "Produto não encontrado!"

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
    private val converter: ProdutoConverter
) {
    fun listar(): List<ProdutoResponseDTO> {
        return repository.findAll()
            .map(converter::toProdutoResponseDTO)
    }

    fun buscarPorId(id: Long): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(PRODUTO_NOT_FOUND_MESSAGE) }
        return converter.toProdutoResponseDTO(produto)
    }

    fun cadastrar(dto: ProdutoDTO): Produto {
        val produto = converter.toProduto(dto)
        return repository.save(produto)
    }

    fun atualizar(id: Long, dto: ProdutoDTO): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(PRODUTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                tipo = dto.tipo,
                preco = dto.preco
            )
        return converter.toProdutoResponseDTO(repository.save(produto))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
