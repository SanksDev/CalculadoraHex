package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Long.parseLong


class MainActivity : AppCompatActivity() {

    var datos3: Long = 0
    var operacionHex=""
    var datosHex=""
    var datosHex2=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hexadecimal()
    }

    fun ejecutarHex(hex1:Long, hex2: Long){
        resultadoTextView.text = ""
        when (operacionHex){
            "+" -> datos3=(hex1+hex2)
            "-" -> datos3=(hex1-hex2)
            "x" -> datos3=(hex1*hex2)
            "/" -> datos3=(hex1/hex2)
        }

        var hexString = java.lang.Long.toHexString(datos3)
        resultadoTextView.text = hexString.toUpperCase()
        datosHex = resultadoTextView.toString()
    }

    fun toHex(hex: String): Long {
        return parseLong(hex,16)
    }

    fun hexadecimal() {
        b0.setOnClickListener(){
            datosHex+="0"
            resultadoTextView.setText(datosHex)
        }
        b1.setOnClickListener(){
            datosHex+="1"
            resultadoTextView.setText(datosHex)
        }
        b2.setOnClickListener(){
            datosHex+="2"
            resultadoTextView.setText(datosHex)
        }
        b3.setOnClickListener(){
            datosHex+="3"
            resultadoTextView.setText(datosHex)
        }
        b4.setOnClickListener(){
            datosHex+="4"
            resultadoTextView.setText(datosHex)
        }
        b5.setOnClickListener(){
            datosHex+="5"
            resultadoTextView.setText(datosHex)
        }
        b6.setOnClickListener(){
            datosHex+="6"
            resultadoTextView.setText(datosHex)
        }
        b7.setOnClickListener(){
            datosHex+="7"
            resultadoTextView.setText(datosHex)
        }
        b8.setOnClickListener(){
            datosHex+="8"
            resultadoTextView.setText(datosHex)
        }
        b9.setOnClickListener(){
            datosHex+="9"
            resultadoTextView.setText(datosHex)
        }
        a.setOnClickListener {
            datosHex+="A"
            resultadoTextView.setText(datosHex)
        }
        b.setOnClickListener {
            datosHex+="B"
            resultadoTextView.setText(datosHex)
        }
        c.setOnClickListener {
            datosHex+="C"
            resultadoTextView.setText(datosHex)
        }
        d.setOnClickListener {
            datosHex+="D"
            resultadoTextView.setText(datosHex)
        }
        e.setOnClickListener {
            datosHex+="E"
            resultadoTextView.setText(datosHex)
        }
        f.setOnClickListener {
            datosHex+="F"
            resultadoTextView.setText(datosHex)
        }
        mas.setOnClickListener(){
            operacionHex="+"
            datosHex2=datosHex
            datosHex=""
        }
        menos.setOnClickListener(){
            datosHex2 = ""
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
        }
        por.setOnClickListener(){
            datosHex2 = ""
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
        }
        bdividir.setOnClickListener() {

            datosHex2 = ""
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
        }

        borrar.setOnClickListener(){
            if(resultadoTextView.text.toString()==""){
                datosHex=""
                resultadoTextView.setText(datosHex)
            }else {
                var datBorrHex = resultadoTextView.text
                val ultHex = datBorrHex.length
                var newDatHex = datBorrHex.substring(0, ultHex - 1)
                datosHex = newDatHex
                resultadoTextView.setText(datosHex)
            }
        }
        delete.setOnClickListener(){
            datosHex=""
            datosHex2=""
            resultadoTextView.setText(datosHex)
        }
        bigual.setOnClickListener(){
                try {
                  ejecutarHex(toHex(datosHex2),toHex(datosHex))
                }catch (e: ArithmeticException) {
                    resultadoTextView.text="No se puede dividir en 0"
                }catch (e: Exception){
                    resultadoTextView.text="0"
                }

        }

        bcosa.setOnClickListener() {
            try {
                var valor = resultadoTextView.text.toString()
                var long = java.lang.Long.parseLong(valor, 16)
                var dato =  long*-1
                var datoN = java.lang.Long.toHexString(dato).toUpperCase()
                resultadoTextView.text = datoN
            }catch (e: Exception) {
                resultadoTextView.text="0"
            }

        }

    }


}