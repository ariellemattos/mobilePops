package com.example.caio.popsodadrink.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager



class SaveSharedPreferences {
    //objetos que irão acompanhar a class funcionam como se fosse métodos static do Java
    //onde n é necessário instanciar a classe para utiliza-

    companion object {
        fun getPreferences(context: Context): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }

        val LOGGED_IN_PREF = "logged_in_status"
        val USER_NAME = "user_name"

        fun setLogged(context: Context, loggedIn: Int) {
            var editor : SharedPreferences.Editor = getPreferences(context).edit()
            editor.putInt(LOGGED_IN_PREF, loggedIn)
            editor.apply()
        }
        //irá setar false como default, já que o user precisa se logar para setar true
        fun getLoggedStatus(context: Context): Int {
            return getPreferences(context).getInt(LOGGED_IN_PREF, 0)
        }
    }
}