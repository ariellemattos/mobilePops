package com.example.caio.popsodadrink.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Promocao (
    @SerializedName("response") @Expose var result: List<Promocao>,
    @SerializedName("id_promocao") var id: Int,
    @SerializedName("titulo") var titulo: String,
    @SerializedName("descricao") var descricao: String,
    @SerializedName("img_promo") var imagem: String
)