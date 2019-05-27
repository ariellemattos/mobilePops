package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.adapter.BrindeAdapter
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.presenter.BrindePresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.BrindeView
import kotlinx.android.synthetic.main.fragment_brindes.*


class BrindesFragment: Fragment(), BrindeView, AdapterView.OnItemClickListener{
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
    //val brindeAdapter : BrindeAdapter = BrindeAdapter(requireActivity(), 0, ArrayList<Brinde>())

    var brindeAdapter : BrindeAdapter? = null
   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var service = ServiceFactory().create()
       val fragmentBrindes = inflater.inflate(R.layout.fragment_brindes, container, false)

       //
       brindeAdapter = BrindeAdapter(this.context)
       val brindePresenter : BrindePresenter


       //entrando dentro do conteúdo da fragment e resgatando os ids dos componentes
       val lstView: ListView = fragmentBrindes.findViewById(R.id.lstBrindes) as ListView

       lstView.adapter = brindeAdapter

       //invocando o presenter junto com o response da API...
       brindePresenter = BrindePresenter(service, this)
       brindePresenter.getBrindes()

       return fragmentBrindes


    }

    override fun getBrindes(brindes: List<Brinde>) {
        brindeAdapter?.clear()
        brindeAdapter?.addAll(brindes)
    }
}