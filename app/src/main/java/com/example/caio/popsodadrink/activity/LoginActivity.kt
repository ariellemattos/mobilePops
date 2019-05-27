package com.example.caio.popsodadrink.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.LoginPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.widget.Toast
import com.example.caio.popsodadrink.utils.SaveSharedPreferences


class LoginActivity : AppCompatActivity(), LoginView {

    val service = ServiceFactory().create()


    override fun getLoginResult(list: List<LoginResult>, success: Boolean) {
        if(success) {
            val alert = AlertDialog.Builder(this)
            putExtra()
            alert.setTitle("Ok")
            alert.setMessage("Autenticado com sucesso!")
            alert.setPositiveButton("Ok", null)
            alert.show()
        } else
            Toast.makeText(applicationContext, "Não foi possível realizar o login", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.caio.popsodadrink.R.layout.activity_login)

        val loginPresenter = LoginPresenter(service, this )
        btn_login.setOnClickListener{
            try {
                loginPresenter.doLogin(txt_user.text.toString(), txt_password.text.toString(), applicationContext)
                //isAutenticado = true
            } catch (erro: Exception){
                erro.localizedMessage
            }
        }

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        txtCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }

    fun putExtra(){
        val intent = Intent(this, DrawerActivity::class.java)
        //intent.putExtra("userId", userId)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)

    }
}
