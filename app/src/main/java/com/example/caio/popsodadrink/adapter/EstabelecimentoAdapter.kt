package com.example.caio.popsodadrink.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.Estabelecimento

class EstabelecimentoAdapter(context: Context?)
    : ArrayAdapter<Estabelecimento>(context, 0, ArrayList<Estabelecimento>()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View?

        view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate( R.layout.cardview_estabelecimentos, parent, false)
        }

        val estabelecimento: Estabelecimento = getItem(position)

        val txt_estabelecimento: TextView = view!!.findViewById(R.id.txt_estabelecimento)
        val txt_logradouro: TextView = view!!.findViewById(R.id.txt_logradouro)
        val txt_telefone: TextView = view!!.findViewById(R.id.txt_telefone)

        txt_estabelecimento.text = estabelecimento.nomeFantasia
        txt_logradouro.text = estabelecimento.logradouro
        txt_telefone.text = estabelecimento.telefone

        return view

    }

}