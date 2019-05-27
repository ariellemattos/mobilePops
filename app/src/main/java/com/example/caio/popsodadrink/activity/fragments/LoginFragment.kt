package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.view.CadastroView


class LoginFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Vincula essa class com o layout criado para a fragment
        return inflater.inflate(R.layout.activity_login, container, false)

        // Remove a barra de status
       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        txtCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }*/

    }
}
