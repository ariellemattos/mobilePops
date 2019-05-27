package com.example.caio.popsodadrink.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Brinde(

    @SerializedName("response") @Expose var result: List<Brinde>,
    @SerializedName("id_brinde") var id: Int,
    @SerializedName("nome") var nome: String,
    @SerializedName("valor_unitario") var valorUnitario: Double,
    @SerializedName("peso") var peso: Double,
    @SerializedName("volume") var volume: Double,
    @SerializedName("imagem") var imagem: String
)