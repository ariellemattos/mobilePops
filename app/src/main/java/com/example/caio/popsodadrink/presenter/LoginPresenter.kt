package com.example.caio.popsodadrink.presenter

import android.content.Context
import android.util.JsonReader
import android.widget.Toast
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.utils.SaveSharedPreferences
import com.example.caio.popsodadrink.view.BrindeView
import com.example.caio.popsodadrink.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal val service: PopsService, internal val loginView: LoginView) {


    fun doLogin( username: String, password: String, context: Context){


        service.loginUsuario(username, password).enqueue(object : Callback<Login>{

            //se a  call na api obter sucesso
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if(response.isSuccessful) {
                    val result = response?.body()
                    loginView.getLoginResult(result!!.response, result?.success)
                    System.out.println(result?.success)

                    if(result?.success){
                        //se o login ser efetuado com sucesso, a variavel de login será 1
                        SaveSharedPreferences.setLogged(context, result.response[0].userId)
                    }
                  }
            }
            //caso ela falhe...
            override fun onFailure(call: Call<Login>, t: Throwable) {
                System.out.println("Não Foi")
                t.localizedMessage
            }
        })
    }


}