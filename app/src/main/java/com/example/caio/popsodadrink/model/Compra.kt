package com.example.caio.popsodadrink.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.*

class Compra (
        @SerializedName("holder") var holder: String,
        @SerializedName("mes") var mes: String,
        @SerializedName("ano") var ano: String,
        @SerializedName("codSeg") var codSeg: String,
        @SerializedName("numCartao") var numCard: String,
        @SerializedName("id_p_fisica") var idPf: String,
        @SerializedName("cpf") var cpf: String,
        @SerializedName("email") var email: String,
        @SerializedName("name") var nome: String,
        @SerializedName("data_nascimento") var dtNasc: String,
        @SerializedName("uf") var uf: String,
        @SerializedName("logradouro") var logradouro: String,
        @SerializedName("cidade") var cidade: String,
        @SerializedName("num") var num: String,
        @SerializedName("cep") var cep: String,
        @SerializedName("item") var item: Item
)