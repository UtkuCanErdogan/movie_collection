package com.erdogan.can.utku.movie.userservice.dto.request

data class CreateUserRequest(
        val name : String,
        val surname : String,
        val age : Int,
        val email : String,
        val username : String,
        val password : String
)
