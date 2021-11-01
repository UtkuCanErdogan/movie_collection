package com.erdogan.can.utku.movie.userservice.model

import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val name : String,
        val surname : String,
        val age : Int,
        val email : String,
        val username : String,
        val password : String,

        @ManyToMany(fetch = FetchType.EAGER)
        val roles : Collection<Role>
){
    constructor(name: String, surname: String, age: Int, email: String, username: String, password: String): this(
            0,
            name, surname, age, email, username, password, ArrayList()
    )

    constructor(id: Long, name: String, surname: String, age: Int, email: String,username: String, password: String)
            : this(
            id, name, surname, age, email, username, password, ArrayList()
    )

}
