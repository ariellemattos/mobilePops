package com.example.caio.popsodadrink.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Promocao
import com.example.caio.popsodadrink.R

class PromocaoAdapter(context: Context?)
    : ArrayAdapter<Promocao>( context,  0,  ArrayList<Promocao>()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var v: View?
        v = convertView

        if (v == null) {
            v = LayoutInflater.from(context).inflate( R.layout.cardview_promocao, parent, false)
        }

        val promocao: Promocao = getItem(position)

        val imgPromocao: ImageView = v!!.findViewById(R.id.img_promo)
        val txtNomePromocao: TextView = v!!.findViewById(R.id.promo_nome)
        val txtDescricaoPromocao: TextView = v!!.findViewById(R.id.promo_descricao)
        val btn: Button = v!!.findViewById(R.id.btn_participar)

        txtNomePromocao.text = promocao.titulo
        txtDescricaoPromocao.text = promocao.descricao

        return v;
    }
}