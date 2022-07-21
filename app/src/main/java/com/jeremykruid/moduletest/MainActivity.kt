package com.jeremykruid.moduletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.jeremykruid.moduletest.ui.theme.ModuleTestTheme
import com.jeremykruid.testmodule.FirebaseTest
import com.jeremykruid.testmodule.TextTest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        val auth = FirebaseAuth.getInstance()
        val firebaseTest = FirebaseTest(application)
        setContent {
            ModuleTestTheme {
                val context = LocalContext.current
//                FirebaseApp.initializeApp(context)
                // A surface container using the 'background' color from the theme
                Column() {
                    Greeting("Android")
                    TextTest()
//                    TestClass().loginUser {
//                        text.value = TestClass().getUId()
//                    }
//
//                    Text(text = text.value
                    firebaseTest.init(auth = auth, context = context)
                    firebaseTest.signInWithEmail()
                    if(firebaseTest.currentUser.value != null) {
                        Text(text = firebaseTest.instance?.currentUser?.email.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModuleTestTheme {
        Greeting("Android")
    }
}