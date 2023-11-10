package com.example.Frango.controller

import com.example.Frango.model.Usuario
import com.example.Frango.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UserController(@Autowired val userService: UserService) {

    // Rota para criar um novo usuário
    @PostMapping
    fun createUser(@RequestBody usuario: Usuario): Usuario {
        return userService.save(usuario)
    }

    // Rota para listar todos os usuários
    @GetMapping
    fun getAllUsers(): List<Usuario> {
        return userService.getAllUsers()
    }

    // Rota para visualizar um usuário pelo ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Usuario {
        return userService.getUserById(id)
    }

    // Rota para atualizar um usuário pelo ID
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody usuario: Usuario): Usuario {
        return userService.updateUser(id, usuario)
    }

    // Rota para excluir um usuário pelo ID
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
}
