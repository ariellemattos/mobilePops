package com.example.caio.popsodadrink.view

import com.example.caio.popsodadrink.model.LoginResult


interface LoginView {

    fun getLoginResult(list: List<LoginResult>, success:Boolean)
}