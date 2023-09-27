package com.example.Frango.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.example.Frango.Entity.Usuario.kt
import com.example.Frango.repository.UserRepository



@Service
class UserService(
    @Autowired val userRepository: UserRepository
) {

    fun findById(id: Long): Usuario? {
        return userRepository.findById(id).orElse(null)
    }

    fun findAll(pageable: Pageable): ResultPage<Usuario> {
        val usuariosPage = userRepository.findAll(pageable)
        return ResultPage(usuariosPage.content, usuariosPage.totalElements)
    }

    @Transactional
    fun save(usuario: Usuario): Usuario {
        return userRepository.save(usuario)
    }

    @Transactional
    fun delete(id: Long) {
        userRepository.deleteById(id)
    }

}
