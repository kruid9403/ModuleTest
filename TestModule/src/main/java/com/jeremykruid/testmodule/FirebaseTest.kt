package com.jeremykruid.testmodule

import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser

class FirebaseTest {

    var instance: FirebaseAuth? = null
    val currentUser = mutableStateOf<FirebaseUser?>(null)

    fun init(firebaseInstance: FirebaseAuth){
        instance = firebaseInstance
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