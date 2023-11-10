package com.example.frango.controller

import com.example.frango.dto.ProdutoDTO
import com.example.frango.dto.ProdutoResponseDTO
import com.example.frango.model.Produto
import com.example.frango.service.ProdutoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(val service: ProdutoService) {

    @GetMapping
    fun listar(): List<ProdutoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProdutoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: ProdutoDTO): ResponseEntity<Produto> {
        val produtoResponse = service.cadastrar(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: ProdutoDTO): ProdutoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
