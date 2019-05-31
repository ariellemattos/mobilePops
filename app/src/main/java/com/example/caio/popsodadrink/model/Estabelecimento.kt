package com.example.caio.popsodadrink.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Estabelecimento(

        @SerializedName("result") @Expose var result: List<Estabelecimento>,
        @SerializedName("cnpj") var cpnj: String,
        @SerializedName("nome_fantasia") var nomeFantasia: String,
        @SerializedName("logradouro") var logradouro: String,
        @SerializedName("telefone") var telefone: String

)