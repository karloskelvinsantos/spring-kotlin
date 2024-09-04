package com.karloskelvin.spring_kotlin.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Driver (
    @Id
    var id:  Long? = null,
    val name: String,
    val birtDate: LocalDate
)