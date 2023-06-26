package com.bookfair.controller

import com.bookfair.controller.response.CustomerResponse
import com.bookfair.extension.toResponse
import com.bookfair.service.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class AdminController() {

    @GetMapping("report")
    fun getAll(@RequestParam name: String?): String {
        return "only an admin can see this"
    }
}