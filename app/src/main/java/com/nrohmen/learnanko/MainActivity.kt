package com.nrohmen.learnanko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            val name = editText()
            button("Show Toast") {
                onClick { toast("Hello, ${name.text}!") }
            }

            button("Show Alert"){
                onClick {
                    alert("Happy Coding!", "Hello, ${name.text}!") {
                        yesButton { toast("Oh…") }
                        noButton {}
                    }.show()
                }
            }

            button("Show Selector"){
                onClick {
                    val code = listOf("Kotlin", "Java", "C++", "PHP")
                    selector("Hello, ${name.text}! Which languages you love?", code, { dialogInterface, i ->
                        toast("So you're love ${code[i]}, right?")
                    })
                }
            }

            button("Show Snackbar"){
                onClick {
                    snackbar(name, "Hello, ${name.text}!")

                }
            }

            button("Show Progress Bar"){
                onClick {
                    indeterminateProgressDialog("Hello, ${name.text}! Please wait...").show()
                }
            }
        }

    }
}
