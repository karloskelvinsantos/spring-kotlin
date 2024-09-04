package com.karloskelvin.spring_kotlin.interfaces

import com.karloskelvin.spring_kotlin.domain.Driver
import com.karloskelvin.spring_kotlin.domain.DriverRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/drivers", produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI (
    val driverRepository: DriverRepository
) {

    @GetMapping
    fun listDrivers() = driverRepository.findAll()
}