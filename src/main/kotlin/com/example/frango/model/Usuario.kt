package com.example.frango.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Usuario(
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,
    val cpf: String,
    val telefone: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,

    @OneToMany(mappedBy = "usuario")
    val inscricoes: List<Inscricao> = listOf()
) : UserDetails {
    override fun getAuthorities(): MutableList<SimpleGrantedAuthority> =
        if (role == UserRole.ADMIN) mutableListOf(
            SimpleGrantedAuthority("ROLE_ADMIN"),
            SimpleGrantedAuthority("ROLE_USER")
        )
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))

    override fun getPassword() = senha // Certifique-se de que 'senha' seja um campo disponível em UsuarioModel

    override fun getUsername() = email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}

