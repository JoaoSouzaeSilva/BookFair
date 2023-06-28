package com.mercadolivro.repository

import com.mercadolivro.helper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @Test
    fun `should return name containing`() {
        val joao = customerRepository.save(buildCustomer(name = "João"))
        val joana = customerRepository.save(buildCustomer(name = "Joana"))
        val debi = customerRepository.save(buildCustomer(name = "Débora"))

        val customers =  customerRepository.findByNameContaining("Jo")

        assertEquals(listOf(joao, joana), customers)
    }

    @Nested
    inner class `exists by email` {

        @Test
        fun `should return true when email exists`() {
            val email = "email@teste.com"
            customerRepository.save(buildCustomer(email = email))

            val exists = customerRepository.existsByEmail(email)

            assertTrue(exists)
        }

        @Test
        fun `should return false when email does not exist`() {
            val email = "nonexistingemail@teste.com"

            val exists = customerRepository.existsByEmail(email)

            assertFalse(exists)
        }

    }

}