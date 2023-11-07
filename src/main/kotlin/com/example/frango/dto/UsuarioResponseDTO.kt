package com.example.frango.dto

data class UsuarioResponseDTO(
    val id: Long?,
    val nome: String,
    val cpf: String,
    val email: String,
    val telefone: String
)
