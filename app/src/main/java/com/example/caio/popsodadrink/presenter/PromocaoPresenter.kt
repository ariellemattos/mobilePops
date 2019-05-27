package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Promocao
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.PromocaoView
import retrofit2.Call
import retrofit2.Response

class PromocaoPresenter(internal val service: PopsService, internal val promocaoView: PromocaoView){
    fun getPromocoes(){
        service.getPromocoes().enqueue(object : retrofit2.Callback<Promocao> {

            override fun onResponse(call: Call<Promocao>, response: Response<Promocao>) {
                if(response.isSuccessful)
                {
                    val promocao = response.body()
                    if (promocao!= null) {
                        promocaoView.getPromocoes(promocao.result)
                    }
                }
            }

            override fun onFailure(call: Call<Promocao>, t: Throwable) {
                t.localizedMessage
            }

        })
    }
}
