package com.example.caio.popsodadrink.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.caio.popsodadrink.model.Compra
import com.example.caio.popsodadrink.model.Item
import com.example.caio.popsodadrink.presenter.CompraPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.CompraView
import kotlinx.android.synthetic.main.activity_pagamento.*


class PagamentoActivity : AppCompatActivity(), CompraView {

    var service = ServiceFactory().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.caio.popsodadrink.R.layout.activity_pagamento)

        var presenter = CompraPresenter(this, service)


        var nomeBrinde = intent.getStringExtra("nome_brinde")
        var valorBrinde = intent.getDoubleExtra("valor_brinde", 0.0)

        valorBrinde *= 100

        Log.w("teste", valorBrinde.toString())

        var item = Item(
                "1",
                nomeBrinde,
                valorBrinde.toInt(),
                1,
                true
        )

        btnBuy.setOnClickListener {

            var compra = Compra(
                    txt_titular.text.toString(),
                    txt_mes.text.toString(),
                    txt_ano.text.toString(),
                    txt_cod.text.toString(),
                    txt_numCartao.text.toString(),
                    "4",
                    "48026003802",
                    "caio.costacarmo@gmail.com",
                    "Caio",
                    "1997-02-10",
                    "SP",
                    "Rua Joaquim Alvarenga",
                    "Jandira",
                    "160",
                    "06626070",
                    item
            )

            presenter.transacao(compra)

        }

    }

    override fun showMessage(titulo: String, mensagem: String) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle(titulo)
        alert.setMessage(mensagem)
        alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> finish() })

        alert.show()
    }

}
