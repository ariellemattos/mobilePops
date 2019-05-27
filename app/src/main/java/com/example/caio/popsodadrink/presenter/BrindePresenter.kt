package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.BrindeView
import retrofit2.Call
import retrofit2.Response

class BrindePresenter(internal val service: PopsService, internal val brindeView: BrindeView) {

    /*
    * O presenter irá cruzar a interface View com o service que faz o request na api
    * */
    fun getBrindes(){
        service.getBrindes().enqueue(object : retrofit2.Callback<Brinde> {
            override fun onResponse(call: Call<Brinde>, response: Response<Brinde>) {
                if(response.isSuccessful)
                {
                    val brinde = response.body() //brinde recebe o retorno da API
                    if (brinde != null) {
                        brindeView.getBrindes(brinde.result)
                    }
                }
            }

            override fun onFailure(call: Call<Brinde>, t: Throwable) {
                t.localizedMessage
            }

        })
    }


}


