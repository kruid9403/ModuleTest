package com.jeremykruid.testmodule

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseAuth.getInstance
import com.google.firebase.auth.FirebaseUser

class FirebaseTest {

    var instance: FirebaseAuth? = null
    val currentUser = mutableStateOf<FirebaseUser?>(null)

    fun init(auth: FirebaseAuth){
        instance = auth
    }

    fun setAuthListener(authChanged: (FirebaseUser?)-> Unit){
        instance?.addAuthStateListener(object : AuthStateListener{
            override fun onAuthStateChanged(p0: FirebaseAuth) {
                currentUser.value = p0.currentUser
                authChanged.invoke(p0.currentUser)
            }
        })
    }

    fun signInWithEmail(){
        instance?.signInWithEmailAndPassword("b@a.com", "111111")
    }

    fun signOut(){
        instance?.signOut()
    }
}