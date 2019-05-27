package com.example.caio.popsodadrink.activity

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.TextView
import android.widget.Toast
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.activity.fragments.BrindesFragment
import com.example.caio.popsodadrink.activity.fragments.EstabelecimentosFragments
import com.example.caio.popsodadrink.activity.fragments.PerfilFragment
import com.example.caio.popsodadrink.activity.fragments.PromocoesFragment
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.UsuarioPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.utils.SaveSharedPreferences
import com.example.caio.popsodadrink.view.LoginView
import com.example.caio.popsodadrink.view.UsuarioView
import kotlinx.android.synthetic.main.activity_drawer.*

import kotlinx.android.synthetic.main.nav_header.*

class DrawerActivity : AppCompatActivity(), UsuarioView {
    companion object {
        //faz a requisição do método para resgatar os dados do usuário
        fun requestOnAPI(id:Int, usuarioView: UsuarioView){

            println(id)

            val service = ServiceFactory().create()

            val presenter =  UsuarioPresenter(service, usuarioView)

            presenter.getUserById(id)
        }
    }


    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        //setando o toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.menu)
        }
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        setupDrawerContent(navigationView)
        var id : Int = SaveSharedPreferences.getLoggedStatus(this)
        println(id)
        if(id > 0) {
            requestOnAPI(id, this)
            println("User alrealdy logged")


        } else
           println("awiwa")
    }


    //permite que o menu drawer possa abrir quando o icon do canto for tocado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //função para fazer o setup do conteúdo do drawer
    private fun setupDrawerContent(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)

            true
        }
    }



    //função para realizar a navegação entre fragments
    fun selectDrawerItem(menuItem: MenuItem){

        // Create a new fragment and specify the fragment to show based on nav item clicked
        var id : Int = SaveSharedPreferences.getLoggedStatus(this)

        var fragment: Fragment

        var fragmentClass: Class<*>? = null

        //a estrutura when funciona como o switch-case de outras linguagens
        when (menuItem.itemId) {

            R.id.nav_brindes ->

                fragmentClass = BrindesFragment::class.java

            R.id.nav_promo ->

                fragmentClass = PromocoesFragment::class.java

            R.id.nav_places ->

                fragmentClass = EstabelecimentosFragments::class.java

            R.id.nav_perfil ->
                //a fragment n será inicializada se o id estiver zerado
                if(id == 0)
                    Toast.makeText(applicationContext, "Você precisa estar logado", Toast.LENGTH_LONG).show()
                else
                    fragmentClass = PerfilFragment::class.java

            R.id.nav_login ->
                //proibindo o usuário de acessar a tela de login novamente
                if(id == 0)
                    startActivity(Intent(this, LoginActivity::class.java))
                else
                    Toast.makeText(applicationContext, "Você já está logado", Toast.LENGTH_LONG).show()
            else ->

                fragmentClass = EstabelecimentosFragments::class.java
        }

        if (fragmentClass != null){
            fragment = fragmentClass?.newInstance() as Fragment

            val fragmentManager = supportFragmentManager

            if (fragment_inicial != null){
                fragmentManager?.beginTransaction()?.hide(fragment_inicial)?.commit()
                fragmentManager?.beginTransaction()?.remove(fragment_inicial)?.commit()
            }

            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
        }
        menuItem.isChecked = true
        drawerLayout.closeDrawers()


    }

    //preenche o nome do usuário no textView
    override fun getUser(list: List<LoginResult>) {
        txt_login.text = list[0].nome
    }
}


