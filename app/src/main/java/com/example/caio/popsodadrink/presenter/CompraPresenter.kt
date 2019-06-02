package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Compra
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.CompraView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompraPresenter(internal var view: CompraView, internal var service: PopsService) {

    fun transacao(compra: Compra){

        service.addBuy(compra).enqueue(object : Callback<ApiResult> {

            override fun onResponse(call: Call<ApiResult>, response: Response<ApiResult>) {

                view.showMessage("Sucesso", "Compra realizada com sucesso!")

            }

            override fun onFailure(call: Call<ApiResult>, t: Throwable) {

                t?.printStackTrace()

                view.showMessage("Falha", "Erro ao fazer a compra!")

            }

        })

    }

}