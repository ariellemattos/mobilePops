package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caio.popsodadrink.R

class EstabelecimentosFragments : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Vincula essa class com o layout criado para a fragment
        return inflater.inflate(R.layout.fragment_estabelecimentos, container, false)
    }
}
