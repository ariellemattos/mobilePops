package com.example.caio.popsodadrink.view

import com.example.caio.popsodadrink.model.Promocao

interface PromocaoView {
    fun getPromocoes(promocoes: List<Promocao>)
}