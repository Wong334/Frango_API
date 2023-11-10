package com.example.Frango.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.Frango.Entity.Usuario.kt
import com.example.Frango.model.Usuario

@Repository
interface UserRepository : JpaRepository<Usuario, Long> {

    fun existsByCategoriesId(id: Long): Boolean

    fun existsByNameIgnoreCase(name: String?): Boolean

    fun existsByIdNotAndNameIgnoreCase(id: Long, name: String?): Boolean
}