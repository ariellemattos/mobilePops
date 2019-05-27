
package com.example.caio.popsodadrink.activity.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caio.popsodadrink.activity.EditarActivity
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.activity.DrawerActivity
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.utils.SaveSharedPreferences
import com.example.caio.popsodadrink.view.UsuarioView
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.android.synthetic.main.fragment_perfil.view.*
import kotlinx.android.synthetic.main.nav_header.*

class PerfilFragment : Fragment(), UsuarioView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Vincula essa class com o layout criado para a fragment
        val view: View = inflater.inflate(R.layout.fragment_perfil, container, false)

        view.editar.setOnClickListener {
            startActivity(Intent(this.context, EditarActivity::class.java))
        }

        val id : Int = SaveSharedPreferences.getLoggedStatus(this.context!!)

        DrawerActivity.requestOnAPI(id, this)

        return view
    }

    override fun getUser(list: List<LoginResult>) {
        txt_login_perfil.text = list[0].login
        println(list[0].login)
        txt_nome_perfil.text = list[0].nome
        txt_cpf_perfil.text = list[0].cpf
        txt_email_perfil.text = list[0].email
    }

}
