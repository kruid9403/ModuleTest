package com.jeremykruid.moduletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.jeremykruid.moduletest.ui.theme.ModuleTestTheme
import com.jeremykruid.testmodule.TextTest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = remember{ mutableStateOf("")}
        setContent {
            ModuleTestTheme {
                // A surface container using the 'background' color from the theme
                Column() {
                    Greeting("Android")
                    TextTest()
//                    TestClass().loginUser {
//                        text.value = TestClass().getUId()
//                    }
//
//                    Text(text = text.value)
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