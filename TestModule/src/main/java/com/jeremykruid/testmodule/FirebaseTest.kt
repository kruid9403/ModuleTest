package com.jeremykruid.testmodule

import com.google.firebase.auth.FirebaseAuth

class FirebaseTest {

    var instance: FirebaseAuth? = null

    fun init(firebaseInstance: FirebaseAuth){
        instance = firebaseInstance
    }
}