package com.karloskelvin.spring_kotlin.interfaces

import com.karloskelvin.spring_kotlin.domain.Driver
import com.karloskelvin.spring_kotlin.domain.DriverRepository
import com.karloskelvin.spring_kotlin.domain.PatchDriver
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/drivers", produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI (
    val driverRepository: DriverRepository
) {

    @PostMapping
    fun createDriver(@RequestBody driver: Driver) = driverRepository.save(driver)

    @PutMapping("/{id}")
    fun fullUpdateDriver(@PathVariable("id") id: Long, @RequestBody driver: Driver) : Driver {
        val foundDriver = findDriver(id)
        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate,
            name = driver.name
        )
        return driverRepository.save(copyDriver)
    }

    @PatchMapping("/{id}")
    fun incrementalUpdateDriver(@PathVariable("id") id: Long, @RequestBody driver: PatchDriver) : Driver {
        val foundDriver = findDriver(id)
        val copyDriver = foundDriver.copy(
            birthDate = driver.birthDate ?:  foundDriver.birthDate,
            name = driver.name ?: foundDriver.name
        )
        return driverRepository.save(copyDriver)
    }

    @GetMapping("/{id}")
    fun findDriver(@PathVariable("id") id: Long) = driverRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @GetMapping
    fun listDrivers() = driverRepository.findAll()

    @DeleteMapping("/{id}")
    fun deleteDriver(@PathVariable("id") id: Long) = driverRepository.delete(findDriver(id))
}