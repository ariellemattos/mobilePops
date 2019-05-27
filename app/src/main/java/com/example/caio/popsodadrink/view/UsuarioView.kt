package com.example.caio.popsodadrink.view

import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario

interface UsuarioView {

    fun getUser(list: List<LoginResult>)
}