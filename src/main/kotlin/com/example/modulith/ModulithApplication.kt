package com.example.modulith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ModulithApplication

fun main(args: Array<String>) {
	runApplication<ModulithApplication>(*args)
}
