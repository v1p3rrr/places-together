package com.vpr.places_together.data.remote.service

import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class GoogleSignInService(private val context: Context) {

    private val googleSignInClient: GoogleSignInClient

    init {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context, gso)
    }

    fun getSignInIntent(): Intent = googleSignInClient.signInIntent

    fun handleSignInResult(data: Intent?): GoogleSignInAccount? {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        return try {
            task.getResult(ApiException::class.java)
        } catch (e: ApiException) {
            Log.w("GoogleSignInService", "signInResult:failed code=" + e.statusCode)
            null
        }
    }
}