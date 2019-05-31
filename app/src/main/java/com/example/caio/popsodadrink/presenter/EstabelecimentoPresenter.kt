package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Estabelecimento
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.EstabelecimentoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EstabelecimentoPresenter(internal val service: PopsService, internal val view: EstabelecimentoView) {

    fun selectAll(){
        service.getEstabelecimentos().enqueue(object : Callback<Estabelecimento>{

            override fun onResponse(call: Call<Estabelecimento>, response: Response<Estabelecimento>) {

                if (response.isSuccessful){

                    val estabelecimento = response.body()

                    if (estabelecimento != null)
                        view.getEstabelecimentos(estabelecimento.result)

                }

            }

            override fun onFailure(call: Call<Estabelecimento>, t: Throwable) {
                t.localizedMessage
            }

        })
    }
}