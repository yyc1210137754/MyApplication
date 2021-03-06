package com.example.AndroidCalculator

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class Calculator : AppCompatActivity(), View.OnClickListener {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        editText = findViewById(R.id.edit_text) as EditText
        val button1 = findViewById(R.id.button_1) as Button
        val button2 = findViewById(R.id.button_2) as Button
        val button3 = findViewById(R.id.button_3) as Button
        val button4 = findViewById(R.id.button_4) as Button
        val button5 = findViewById(R.id.button_5) as Button
        val button6 = findViewById(R.id.button_6) as Button
        val button7 = findViewById(R.id.button_7) as Button
        val button8 = findViewById(R.id.button_8) as Button
        val button9 = findViewById(R.id.button_9) as Button
        val button0 = findViewById(R.id.button_0) as Button
        val button_add = findViewById(R.id.button_add) as Button
        val button_sub = findViewById(R.id.button_sub) as Button
        val button_mul = findViewById(R.id.button_mul) as Button
        val button_div = findViewById(R.id.button_div) as Button
        val button_del = findViewById(R.id.button_del) as Button
        val button_neg = findViewById(R.id.button_neg) as Button
        val button_equ = findViewById(R.id.button_equ) as Button
        val button_pt = findViewById(R.id.button_pt) as Button
        val button_pc = findViewById(R.id.button_pc) as Button
        val button_fac = findViewById(R.id.button_fac) as Button
        val button_c = findViewById(R.id.button_c) as Button
        val button_root = findViewById(R.id.button_root) as Button
        val button_log = findViewById(R.id.button_log) as Button
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)
        button_del.setOnClickListener(this)
        button_neg.setOnClickListener(this)
        button_equ.setOnClickListener(this)
        button_pt.setOnClickListener(this)
        button_pc.setOnClickListener(this)
        button_fac.setOnClickListener(this)
        button_c.setOnClickListener(this)
        button_root.setOnClickListener(this)

        button_log.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var et = editText.getText().toString()
        when (v?.getId()) {
            R.id.button_log ->if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.'
            ){
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            }else{
                val res = getResult()
                if (res.contains("Infinity")) {
                    Toast.makeText(
                        this@Calculator,
                        "0 cannot be used as a divior!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {
                    var x1=res.toDouble()
                    x1= Math.cos(Math.PI/(180/x1))
                    var x2 = formatResult(x1)
                    editText.setText(x2)
                }
            }
            R.id.button_0 -> {
                if (et == "0") et = "0" else et += "0"
                editText.setText(et)
            }
            R.id.button_1 -> {
                if (et == "0") et = "1" else et += "1"
                editText.setText(et)
            }
            R.id.button_2 -> {
                if (et == "0") et = "2" else et += "2"
                editText.setText(et)
            }
            R.id.button_3 -> {
                if (et == "0") et = "3" else et += "3"
                editText.setText(et)
            }
            R.id.button_4 -> {
                if (et == "0") et = "4" else et += "4"
                editText.setText(et)
            }
            R.id.button_5 -> {
                if (et == "0") et = "5" else et += "5"
                editText.setText(et)
            }
            R.id.button_6 -> {
                if (et == "0") et = "6" else et += "6"
                editText.setText(et)
            }
            R.id.button_7 -> {
                if (et == "0") et = "7" else et += "7"
                editText.setText(et)
            }
            R.id.button_8 -> {
                if (et == "0") et = "8" else et += "8"
                editText.setText(et)
            }
            R.id.button_9 -> {
                if (et == "0") et = "9" else et += "9"
                editText.setText(et)
            }
            R.id.button_pt -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.' ||
                (!et.contains("+") &&
                        !et.contains("-") &&
                        !et.contains("??") &&
                        !et.contains("??") &&
                        et.contains("."))
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "."
                editText.setText(et)
            }
            R.id.button_add -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "+"
                editText.setText(et)
            }
            R.id.button_sub -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "-"
                editText.setText(et)
            }
            R.id.button_mul -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "??"
                editText.setText(et)
            }
            R.id.button_div -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "??"
                editText.setText(et)
            }
            R.id.button_del -> {
                et = if (et.length > 1) {
                    if (et.length == 2 && et[0] == '-') {
                        "0"
                    } else et.substring(0, et.length - 1)
                } else {
                    "0"
                }
                editText.setText(et)
            }
            R.id.button_c -> {
                et = "0"
                editText.setText(et)
            }
            R.id.button_equ -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??') {
                Toast.makeText(
                    this@Calculator,
                    "Please complete the formula!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText(et)
            } else {
                val res = getResult()
                if (res.contains("Infinity")) {
                    Toast.makeText(
                        this@Calculator,
                        "0 cannot be used as a divior!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {
                    editText.setText(res)
                }
            }
            R.id.button_pc -> {
                var per = et.toDouble()
                per = per / 100
                var per1 = "" + per
                per1 = per1.replace("0+?$".toRegex(), "")
                per1 = per1.replace("[.]$".toRegex(), "")
                editText.setText(per1)
            }
            R.id.button_neg -> if (et[0] >= '0' && et[0] <= '9') {
                if (et == "0") {
                    editText.setText("0")
                } else {
                    editText.setText("-$et")
                }
            } else if (et[0] == '-') editText.setText(
                et.substring(1, et.length)
            ) else editText.setText(et)
            R.id.button_fac -> if (et.contains(".")) {
                Toast.makeText(this@Calculator,
                    "Not integer!",
                    Toast.LENGTH_SHORT).show()
            } else if (et[0] == '-') {
                Toast.makeText(this@Calculator,
                    "Not positive!",
                    Toast.LENGTH_SHORT).show()
            } else {
                if (et == "0") {
                    et = "1"
                    editText.setText(et)
                } else {
                    val num = et.toInt().toDouble()
                    var result = 1.0
                    var i = 1
                    while (i <= num) {
                        result = result * i
                        i++
                    }
                    et = result.toString()
                    editText.setText(et)
                }
            }
            R.id.button_root -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '??' ||
                et[et.length - 1] == '??') {
                Toast.makeText(
                    this@Calculator,
                    "Please complete the formula!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText(et)
            }
            else if (et[0] == '-') {
                Toast.makeText(
                    this@Calculator,
                    "Negative numbers cannot be squared!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText("0")
            }else{
                val res = getResult()
                if (res.contains("Infinity")) {
                    Toast.makeText(
                        this@Calculator,
                        "Symbols cannot be squared!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {
                    var x = res.toDouble()
                    x = Math.sqrt(x)
                    var x2 = formatResult(x)
                    editText.setText(x2)
                }

            }
            else -> {
                Toast.makeText(this@Calculator,
                    "Unexpected error!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun formatResult(result: Double): String {
        var re = String.format("%.9f", result)
        re = re.replace("0+?$".toRegex(), "")
        re = re.replace("[.]$".toRegex(), "")
        return re
    }

    fun getResult(): String {
        val infix = editText.getText().toString()
        val postfix = toPostfix(infix)
        val result = toValue(postfix)
        var re = formatResult(result)
        return re
    }


    fun toPostfix(infix: String): StringBuffer {//????????????????????????????????????
        val stack = Stack<String>()//??????????????????????????????????????????
        //?????????????????????????????????????????????String????????????
        val postfix = StringBuffer(infix.length * 2)//????????????(StringBuffer)
        var i = 0//????????????
        while (i < infix.length) {//??????
            var ch = infix.get(i)//i<???????????????ch????????????
            when (ch) {//??????
                '+' -> {//??????
                    while (!stack.isEmpty() && stack.peek() != "(")
                        postfix.append(stack.pop())//??????????????????????????????
                    stack.push(ch.toString() + "")//???????????? ??????
                    i++//i+1
                }
                '-' -> if (i == 0) {//??????i???1???
                    postfix.append(0)//??????0
                    postfix.append(" ")
                    stack.push("(")//??????
                    stack.push(ch.toString() + "")//?????????????????? ??????
                    i++//i+1
                } else {//?????????
                    while (!stack.isEmpty() && stack.peek() != "(")//????????????
                        postfix.append(stack.pop())//???????????????
                    stack.push(ch.toString() + "")//?????????????????? ??????
                    i++//i+1
                }
                '??', '??' -> {//????????????
                    while (!stack.isEmpty() &&//?????? ????????????
                        (stack.peek() == "??" || stack.peek() == "??"))//??????
                        postfix.append(stack.pop())//??????????????????
                    stack.push(ch.toString() + "")//???????????? ??????
                    i++//i+1
                }
                else -> if (i == 1 && infix.get(0) == '-') {//??????i???1???infix????????????-??????
                    while (i < infix.length && ch >= '0' && ch <= '9' ||//i<infix????????????ch>=0???<ch<=9
                        i < infix.length && ch == '.') {//i<infix?????????ch=.
                        postfix.append(ch)//???postfix?????????ch
                        i++//i+1
                        if (i < infix.length) ch = infix.get(i)//??????i<???????????????ch????????????
                    }
                    postfix.append(" ")//postfix?????????
                    postfix.append('-')//??????-
                    stack.pop()
                    stack.pop()
                } else {
                    while (i < infix.length && ch >= '0' && ch <= '9' ||//i<infix???ch>=0???ch<=9
                        i < infix.length && ch == '.') {//i<infix?????????ch=.
                        postfix.append(ch)//????????????
                        i++//i+1
                        if (i < infix.length) ch = infix.get(i)//??????i<infix???????????????ch??????
                    }
                    postfix.append(" ")//??????
                }
            }
        }
        while (!stack.isEmpty())//??????????????????
            postfix.append(stack.pop())//?????????????????????
        return postfix//?????? ???
    }

    fun toValue(postfix: StringBuffer): Double {//??????toValue()??????
        val stack = Stack<Double>()//??????double????????????
        var value = 0.0//????????????
        var j = 0
        var i = 0
        while (i < postfix.length) {//??????i<postfix
            j = i//???j????????????i
            var ch = postfix.get(i)//????????????ch????????????i???
            if (ch >= '0' && ch <= '9' || ch == '.') {//??????ch??????0-9????????????.
                value = 0.0//???????????????0
                while (ch != ' ') {//ch??????
                    while (ch != ' ' && ch != '.') {//ch?????????ch??????.
                        value = value * 10.0 + (ch - '0').toDouble()//?????????????????????
                        j++       //j+1
                        ch = postfix.get(++i)  //??????ch???
                    }
                    if (ch != ' ' && ch == '.')   //??????ch???????????????.
                        ch = postfix.get(++i)       //??????ch???
                    while (ch != ' ' && i >= j + 1) {       //???ch????????????i??????j+1
                        val valueBD = BigDecimal(value.toString())   //???String?????????????????????BigDecimal??????
                        val chBD = BigDecimal(ch - '0')  //??????chBD   BigDecimal???0?????????
                        val nBD = BigDecimal(Math.pow(10.0, (i - j).toDouble()))//10??????
                        val temp = chBD.divide(nBD)//??????temp  chBD??????nBD??????
                        value = valueBD.add(temp).toDouble()   //value?????? Double???????????????temp??????valueBD???
                        ch = postfix.get(++i)  //ch????????????
                    }
                    stack.push(value) //??????
                }
            } else {   //??????
                if (ch != ' ') { //??????ch??????
                    var y: Double = stack.pop()//??????y?????????????????????
                    var x: Double = stack.pop() //??????x?????????????????????
                    value = when (ch) {//??????value   ?????????
                        '+' -> x + y//???+????????????x+y
                        '-' -> x - y//???-????????????x-y
                        '??' -> x * y //???*????????????x*y
                        '??' -> x / y //?????????????????x/y
                        else -> 0.0 //?????????0
                    }
                    stack.push(value)//value????????????
                }
            }
            i++ //i+1
        }
        return stack.pop()//????????????????????????
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //???????????????
        //nflate():??????1-??????????????????????????????      ??????2-?????????????????????????????????Menu?????????
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    /**
     * ????????????????????????
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //?????????????????????
            R.id.visit_item -> {
                Toast.makeText(this, "????????????????????????", Toast.LENGTH_SHORT).show()
                //????????????Activity
                finish()
            }

            //???????????????
            R.id.quit_item -> {
                Toast.makeText(this, "??????????????????", Toast.LENGTH_SHORT).show()
                //????????????Activity


            }
        }
        return true
    }
}