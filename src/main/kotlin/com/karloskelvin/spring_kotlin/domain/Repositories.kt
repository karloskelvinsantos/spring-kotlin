package com.karloskelvin.spring_kotlin.domain

import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository<Driver, Long>