package com.example.frango.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.frango.model.Usuario
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {


    fun findByEmail(email: String): UserDetails
}