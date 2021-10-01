package com.erdogan.can.utku.movie.model

import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val userName : String,
        val password : String,

        @ManyToMany(fetch = FetchType.EAGER)
        val roles : Collection<UserRoles>
)
