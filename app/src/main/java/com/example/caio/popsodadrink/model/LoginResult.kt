package com.example.caio.popsodadrink.model

import com.google.gson.annotations.SerializedName

class LoginResult (
        @SerializedName("response")
        var response: List<LoginResult>,
        @SerializedName("id_p_fisica")
        var userId: Int,
    @SerializedName("nome")
    var nome: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("cpf")
    var cpf: String,

    @SerializedName("usuario")
    var login: String
    )