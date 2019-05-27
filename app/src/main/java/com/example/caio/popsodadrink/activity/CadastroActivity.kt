package com.example.caio.popsodadrink.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.CadastroPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.CadastroView
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity(), CadastroView {
    
    var service = ServiceFactory().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        var presenter = CadastroPresenter(this, service)

        btn_cadastro.setOnClickListener {

            var usuario = Usuario(

                    txt_nome.text.toString(),
                    txt_email.text.toString(),
                    txt_cpf.text.toString(),
                    txt_usuario.text.toString(),
                    txt_senha.text.toString()
                    )

            presenter.cadastrarUsuario(usuario)

        }

    }

    override fun showMessage(titulo: String, mensagem: String) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle(titulo)
        alert.setMessage(mensagem)
        alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> finish() })

        alert.show()
    }

}
