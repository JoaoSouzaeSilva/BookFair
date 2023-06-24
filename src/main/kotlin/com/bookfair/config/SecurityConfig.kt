package com.bookfair.config

import com.bookfair.repository.CustomerRepository
import com.bookfair.security.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerRepository: CustomerRepository
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.invoke {

            csrf { disable() }
            cors { disable() }

            authorizeRequests {
                authorize(HttpMethod.POST,"/customers", permitAll)
                authorize(anyRequest,authenticated)
            }

            sessionManagement { SessionCreationPolicy.STATELESS }
        }

        //http.addFilter(AuthenticationFilter(, customerRepository))

        return http.build()
    }


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}