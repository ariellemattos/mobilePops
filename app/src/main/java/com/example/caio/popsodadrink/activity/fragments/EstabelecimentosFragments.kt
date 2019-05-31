package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.adapter.EstabelecimentoAdapter
import com.example.caio.popsodadrink.model.Estabelecimento
import com.example.caio.popsodadrink.presenter.EstabelecimentoPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.EstabelecimentoView

class EstabelecimentosFragments : Fragment(), EstabelecimentoView {

    var adapter: EstabelecimentoAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var service = ServiceFactory().create()

        //Vincula essa class com o layout criado para a fragment
         val fragmentEstabelecimento = inflater.inflate(R.layout.fragment_estabelecimentos, container, false)

        adapter = EstabelecimentoAdapter(this.context)

        val presenter: EstabelecimentoPresenter

        //entrando dentro do conteúdo da fragment e resgatando os ids dos componentes
        val lstView: ListView = fragmentEstabelecimento.findViewById(R.id.lstEstabelecimentos) as ListView

        lstView.adapter = adapter

        presenter = EstabelecimentoPresenter(service, this)
        presenter.selectAll()

        return fragmentEstabelecimento

    }

    override fun getEstabelecimentos(estabelecimentos: List<Estabelecimento>) {
        adapter?.clear()
        adapter?.addAll(estabelecimentos)
    }

}
