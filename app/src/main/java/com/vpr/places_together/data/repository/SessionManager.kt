package com.vpr.places_together.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.vpr.places_together.domain.model.Account
import javax.inject.Inject

class SessionManager @Inject constructor(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("session_prefs", Context.MODE_PRIVATE)

    var activeAccount: Account?
        get() {
            val json = sharedPreferences.getString("active_account", null)
            return if (json != null) {
                Gson().fromJson(json, Account::class.java)
            } else {
                null
            }
        }
        set(value) {
            val editor = sharedPreferences.edit()
            if (value != null) {
                val json = Gson().toJson(value)
                editor.putString("active_account", json)
            } else {
                editor.remove("active_account")
            }
            editor.apply()
        }
}