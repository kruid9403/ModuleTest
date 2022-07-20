package com.jeremykruid.testmodule

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.firebase.auth.FirebaseAuth

class TestClass() {
    @Composable
    fun TextTest() {
        Text(text = "some text that might work")
    }

    fun getUId(): String {
        return FirebaseAuth.getInstance().currentUser.toString()
    }

    fun loginUser(loggedIn: () -> Unit) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword("a@a.com", "111111")
            .addOnCompleteListener {
                loggedIn.invoke()
            }
    }
}