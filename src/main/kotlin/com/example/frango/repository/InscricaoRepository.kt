package com.example.frango.repository

import com.example.frango.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long>