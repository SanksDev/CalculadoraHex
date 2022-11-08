package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Long.parseLong


class MainActivity : AppCompatActivity() {

    var datos3: Long = 0
    var memoriaHex=""
    var operacionHex=""
    var datosHex=""
    var datosHex2=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hexadecimal()
    }

    fun ejecutarHex(hex1:Long, hex2: Long){
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
            resultadoTextView.text=datosHex2+"+"
        }
        menos.setOnClickListener(){
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
            resultadoTextView.text=datosHex2+"-"
        }
        por.setOnClickListener(){
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
            resultadoTextView.text=datosHex2+"x"
        }
        bdividir.setOnClickListener() {
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
            resultadoTextView.text=datosHex2+"/"
        }

        bigual.setOnClickListener(){
            if(memoriaHex=="") {
                memoriaHex = resultadoTextView.text.toString()
            }else{
                resultadoTextView.text = memoriaHex
            }
        }

        bigual.setOnClickListener(){
            datosHex2=memoriaHex
            resultadoTextView.text = datosHex2+"+"
            operacionHex="+"
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
            if(datosHex2=="") datosHex2="0"
            try {
                ejecutarHex(toHex(datosHex2),toHex(datosHex))
            }catch (e: ArithmeticException){
                resultadoTextView.text="Error: No se puede dividir en 0"
            }
        }

        bcosa.setOnClickListener() {
            var num: String = resultadoTextView.text.toString()
            if (resultadoTextView.text.toString()=="") {
                resultadoTextView.setText(resultadoTextView.text)
            }else if(num.contains("-(${resultadoTextView.text})")){
                resultadoTextView.setText("${resultadoTextView.text}")
            } else {
                resultadoTextView.setText("-(${resultadoTextView.text})")
            }
        }

    }


}