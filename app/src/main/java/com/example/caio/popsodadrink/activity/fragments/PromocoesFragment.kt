package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.adapter.PromocaoAdapter
import com.example.caio.popsodadrink.model.Promocao
import com.example.caio.popsodadrink.presenter.PromocaoPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.PromocaoView
import kotlinx.android.synthetic.main.cardview_promocao.*

class PromocoesFragment : Fragment(), PromocaoView, AdapterView.OnItemClickListener{
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    var promocaoAdapter : PromocaoAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var service = ServiceFactory().create()
        val fragmentPromocoes = inflater.inflate(R.layout.fragment_promocoes, container, false)


        promocaoAdapter = PromocaoAdapter(this.context)
        val promocaoPresenter : PromocaoPresenter

        //entrando dentro do conteúdo da fragment e resgatando os ids dos componentes
        val lstView: ListView = fragmentPromocoes.findViewById(R.id.lstPromocoes) as ListView

        lstView.adapter = promocaoAdapter

        //invocando o presenter junto com o response da API...
        promocaoPresenter = PromocaoPresenter(service, this)
        promocaoPresenter.getPromocoes()


        return fragmentPromocoes

    }

    override fun getPromocoes(promocoes: List<Promocao>) {
        promocaoAdapter?.clear()
        promocaoAdapter?.addAll(promocoes)
    }


}
