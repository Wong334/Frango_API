package com.example.frango.service

import org.springframework.stereotype.Service
import com.example.frango.model.Usuario
import com.example.frango.dto.UsuarioDTO
import com.example.frango.repository.UsuarioRepository
import com.example.frango.converters.UsuarioConverter
import com.example.frango.dto.UsuarioResponseDTO
import com.example.frango.exceptions.NotFoundException
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val converter: UsuarioConverter
) {
    fun listar(): List<UsuarioResponseDTO> {
        return repository.findAll()
                .map(converter::toUsuarioResponseDTO)
    }

    fun buscarPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): Usuario {
        val usuario = converter.toUsuario(dto)
        return repository.save(converter.toUsuario(dto));
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                cpf = dto.cpf,
                email = dto.email,
                telefone = dto.telefone
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}

