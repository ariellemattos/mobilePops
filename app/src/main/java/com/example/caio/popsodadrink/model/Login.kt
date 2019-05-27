package com.example.caio.popsodadrink.model


import com.example.caio.popsodadrink.model.Brinde
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Login (
        @SerializedName("success") @Expose var success: Boolean,
        @SerializedName("message") @Expose var message: String,
        @SerializedName("response") @Expose var response: List<LoginResult>
        )
