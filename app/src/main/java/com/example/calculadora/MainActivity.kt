package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener { numeroPresionado(digito = "1") }
        b2.setOnClickListener { numeroPresionado(digito = "2") }
        b3.setOnClickListener { numeroPresionado(digito = "3") }
        b4.setOnClickListener { numeroPresionado(digito = "4") }
        b5.setOnClickListener { numeroPresionado(digito = "5") }
        b6.setOnClickListener { numeroPresionado(digito = "6") }
        b7.setOnClickListener { numeroPresionado(digito = "7") }
        b8.setOnClickListener { numeroPresionado(digito = "8") }
        b9.setOnClickListener { numeroPresionado(digito = "9") }
        b0.setOnClickListener { numeroPresionado(digito = "0") }

        mas.setOnClickListener { operacionPresionada(SUMA) }
        menos.setOnClickListener { operacionPresionada(RESTA) }
        por.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        bdividir.setOnClickListener { operacionPresionada(DIVISION) }

        delete.setOnClickListener {
            resetear()
        }

        bigual.setOnClickListener { resolverOperacion() }


    }

    private fun numeroPresionado(digito: String) {

        if (resultadoTextView.text == "0" && digito != ".") {
            resultadoTextView.text = "$digito"
        } else {
            resultadoTextView.text = "${resultadoTextView.text}$digito"
        }

        if (operacion == NO_OPERACION) {
            num1 = resultadoTextView.text.toString().toDouble()
        } else {
            num2 = resultadoTextView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int) {

        this.operacion = operacion
        num1 = resultadoTextView.text.toString().toDouble()

        resultadoTextView.text = "0"
    }

    private fun resolverOperacion() {
        bigual.setOnClickListener {

            var resultado = when (operacion) {
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2

                else -> 0
            }

            num1 = resultado as Double

            resultadoTextView.text = if ("$resultado".endsWith(".0")) {
                "$resultado".replace(".0", "")
            } else {
                "%.2f".format(resultado)
            }

        }
    }

    private fun  resetear(){
        num1 = 0.0
        num2 = 0.0
        resultadoTextView.text = "0"
        operacion = NO_OPERACION
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
}