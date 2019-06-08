package com.example.caio.popsodadrink.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.caio.popsodadrink.activity.PagamentoActivity
import com.example.caio.popsodadrink.model.Brinde
import com.squareup.picasso.Picasso


class BrindeAdapter(context: Context?)
    : ArrayAdapter<Brinde>( context,  0,  ArrayList<Brinde>()) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var v: View?
        v = convertView

        if(v == null){
            v = LayoutInflater.from(context).inflate(com.example.caio.popsodadrink.R.layout.cardview_brinde, parent, false)
        }

        val brinde: Brinde = getItem(position)

        //!! converte qualquer valor para um non-null, e retorna ua exception se o valor já vier nulo
        val imgBrinde: ImageView = v!!.findViewById(com.example.caio.popsodadrink.R.id.img_brinde)
        val txtNameBrinde: TextView = v!!.findViewById(com.example.caio.popsodadrink.R.id.brinde_name)
        val txtPriceBrinde: TextView = v!!.findViewById(com.example.caio.popsodadrink.R.id.brinde_price)
        val btnCompra: Button = v!!.findViewById(com.example.caio.popsodadrink.R.id.btnCompra)

        btnCompra.setOnClickListener {
            val intent = Intent(this.context, PagamentoActivity::class.java)

            intent.putExtra("nome_brinde", brinde.nome)
            intent.putExtra("valor_brinde", brinde.valorUnitario)

            context.startActivity(intent)
        }

        Picasso.get().load("http://www.bebidaspops.com.br/cms/view/img/temp/" + brinde.imagem).into(imgBrinde)
        txtNameBrinde.text = brinde.nome
        txtPriceBrinde.text = "R$ " + brinde.valorUnitario.toString()

        return v
    }

}

