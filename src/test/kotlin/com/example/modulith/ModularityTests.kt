package com.example.modulith

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter





class ModularityTests {

    var modules: ApplicationModules = ApplicationModules.of(ModulithApplication::class.java)

    @Test
    fun verifiesModularStructure() {
        modules.forEach { println(it) }
        modules.verify()
    }

    @Test
    fun createModuleDocumentation() {
        Documenter(modules).writeDocumentation()
    }
}