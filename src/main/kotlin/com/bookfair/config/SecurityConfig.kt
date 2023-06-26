package com.bookfair.config

import com.bookfair.repository.CustomerRepository
import com.bookfair.security.AuthenticationFilter
import com.bookfair.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer
import org.springframework.security.config.annotation.web.WebSecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerRepository: CustomerRepository,
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val userDetailsCustomService: UserDetailsCustomService
) {

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.invoke {

            csrf { disable() }
            cors { disable() }

            authorizeRequests {
                authorize(HttpMethod.POST, "/customers", permitAll)
                authorize(HttpMethod.POST,"/books", permitAll)
                authorize(anyRequest,authenticated)
            }

            sessionManagement { SessionCreationPolicy.STATELESS }
        }

        http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository))
        http.authenticationProvider(authProvider())

        return http.build()
    }

    @Bean
    fun authProvider(): DaoAuthenticationProvider {

        val authProvider = DaoAuthenticationProvider()

        authProvider.setUserDetailsService(userDetailsCustomService)
        authProvider.setPasswordEncoder(bCryptPasswordEncoder())

        return authProvider
    }


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}