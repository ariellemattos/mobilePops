package com.example.caio.popsodadrink.service

import com.example.caio.popsodadrink.model.*
import retrofit2.Call
import retrofit2.http.*


interface PopsService {

    @POST("/user/add")
    fun cadastrarUsuario(@Body usuario: Usuario): Call<ApiResult>

    @POST("/brinde/buy")
    fun addBuy(@Body compra: Compra): Call<ApiResult>

    @FormUrlEncoded
    @POST("/user/login")
    fun loginUsuario(
            //parametros necessários para retornar os dados do Usuario logado
            @Field("user") username: String,
            @Field("password")password: String
            ): Call<Login>

    @GET("/brinde")
    fun getBrindes(): Call<Brinde>

    @GET("/brinde/{brinde_id}")
    fun getBrinde(@Path("brinde_id") brindeId: Int): Call<Brinde>

    @GET("/promo")
    fun getPromocoes(): Call<Promocao>

    @GET("/estabelecimentos")
    fun getEstabelecimentos(): Call<Estabelecimento>

    @GET("/user/{user_id}")
    fun getUserById(
           @Path("user_id") userId: Int
    ): Call<LoginResult>

}