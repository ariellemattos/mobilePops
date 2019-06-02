package com.example.caio.popsodadrink.activity.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.activity.PagamentoActivity
import com.example.caio.popsodadrink.adapter.BrindeAdapter
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.presenter.BrindePresenter
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.BrindeView
import kotlin.math.log


class BrindesFragment: Fragment(), BrindeView{

    private var brindeAdapter : BrindeAdapter? = null
   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var service: PopsService = ServiceFactory().create()
       val fragmentBrindes = inflater.inflate(R.layout.fragment_brindes, container, false)

       //
       brindeAdapter = BrindeAdapter(this.context)
       val bridePresenter : BrindePresenter


       //entrando dentro do conteúdo da fragment e resgatando os ids dos componentes
       val lstView: ListView = fragmentBrindes.findViewById(R.id.lstBrindes) as ListView

       lstView.adapter = brindeAdapter

       //invocando o presenter junto com o response da API...
       bridePresenter = BrindePresenter(service, this)
       bridePresenter.getBrindes()

       return fragmentBrindes


    }

    override fun getBrindes(brindes: List<Brinde>) {
        brindeAdapter?.clear()
        brindeAdapter?.addAll(brindes)
    }

}