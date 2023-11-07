package com.example.frango.converters

import com.example.frango.dto.UsuarioDTO
import com.example.frango.dto.UsuarioResponseDTO
import com.example.frango.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                cpf = usuario.cpf,
                email = usuario.email,
                telefone = usuario.telefone)
    }

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
                nome = dto.nome,
                cpf = dto.cpf,
                email = dto.email,
                telefone = dto.telefone,
                senha = BCryptPasswordEncoder().encode(dto.senha)
        )

    }
}