package com.yasince.sahibinden.data.network.model

class User {
    val id: Long? = 0
    val firstname: String? = ""
    val lastName: String? = ""
    val userpic_url: String? = ""
    val city: String? = ""
    val country: String? = ""

    fun fullName(): String {
        return StringBuilder().append(firstname).append(" ").append(lastName).toString()
    }
}
