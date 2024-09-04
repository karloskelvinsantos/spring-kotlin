package com.karloskelvin.spring_kotlin.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Driver (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:  Long? = null,
    val name: String,
    val birthDate: LocalDate
)

data class PatchDriver (
    val name: String?,
    val birthDate: LocalDate?
)