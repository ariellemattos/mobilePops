package com.example.caio.popsodadrink.model

import com.google.gson.annotations.SerializedName

class Item (
        @SerializedName("id") var id_brinde : String,
        @SerializedName("title") var titulo : String,
        @SerializedName("unit_price") var preco_unitario : Int,
        @SerializedName("quantity") var qtd : Int,
        @SerializedName("tangible") var tangible : Boolean
)