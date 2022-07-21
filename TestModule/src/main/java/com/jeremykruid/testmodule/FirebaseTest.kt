package com.jeremykruid.testmodule

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser

class FirebaseTest(application: Application): AndroidViewModel(application) {

    var instance: FirebaseAuth? = null
    val currentUser = mutableStateOf<FirebaseUser?>(null)

    fun init(auth: FirebaseAuth, context: Context){
        FirebaseApp.initializeApp(getApplication())
        instance = auth
        setAuthListener()
    }

    fun setAuthListener(){
        instance?.addAuthStateListener(object : AuthStateListener{
            override fun onAuthStateChanged(p0: FirebaseAuth) {
                currentUser.value = p0.currentUser
            }
        })
    }

    fun signInWithEmail(){
        instance?.signInWithEmailAndPassword("a@a.com", "111111")
    }
}