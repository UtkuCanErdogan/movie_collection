package com.erdogan.can.utku.movie.userservice.dto.response

data class UserDto(
        val id : Long,
        val name : String,
        val surname : String,
        val age : Int,
        val email : String,
        val username : String
)
