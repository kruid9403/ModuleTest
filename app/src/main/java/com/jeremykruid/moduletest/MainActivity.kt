package com.jeremykruid.moduletest

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.jeremykruid.moduletest.ui.theme.ModuleTestTheme
import com.jeremykruid.testmodule.FirebaseTest
import com.jeremykruid.testmodule.TextTest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val options = FirebaseOptions.Builder()
        options.setApiKey("AIzaSyCd6Oy6xIq_BmAzGN1J7iPb57iug0Q5h-A")
        options.setApplicationId("1:277277686872:android:1faeb3a3ed990722279e2d")
        val firebaseTest = FirebaseTest()
        FirebaseApp.initializeApp(this, options.build())
        val auth = FirebaseAuth.getInstance()
        setContent {
            ModuleTestTheme {
                val firstRun = remember { mutableStateOf(true)}
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
                    firebaseTest.init(auth = auth)
                    firebaseTest.setAuthListener(
                        authChanged = {
                            Toast.makeText(context, it?.uid.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                    if (firstRun.value) {
                        firebaseTest.signInWithEmail()
                        firstRun.value = false
                    }
                    if(firebaseTest.currentUser.value != null) {
                        Text(text = firebaseTest.instance?.currentUser?.email.toString())
                    }
                    Handler().postDelayed({
                        firebaseTest.signOut()
                    },5000)
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