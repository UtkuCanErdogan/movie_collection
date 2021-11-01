package com.erdogan.can.utku.movie.userservice.model

import javax.persistence.*

@Entity
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val name : String,
){
    constructor(name: String): this(
            0,
            name
    )
}
