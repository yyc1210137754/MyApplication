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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.' ||
                (!et.contains("+") &&
                        !et.contains("-") &&
                        !et.contains("×") &&
                        !et.contains("÷") &&
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "×"
                editText.setText(et)
            }
            R.id.button_div -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@Calculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "÷"
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷') {
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
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷') {
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


    fun toPostfix(infix: String): StringBuffer {//使用运算符栈来储存运算符
        val stack = Stack<String>()//中缀表达式转化成为后缀表达式
        //将运算符送到运算符栈，创建一个String类型的栈
        val postfix = StringBuffer(infix.length * 2)//声明常量(StringBuffer)
        var i = 0//生明变量
        while (i < infix.length) {//循环
            var ch = infix.get(i)//i<长度，变量ch赋予位置
            when (ch) {//判断
                '+' -> {//加号
                    while (!stack.isEmpty() && stack.peek() != "(")
                        postfix.append(stack.pop())//栈不为空，加弹出的栈
                    stack.push(ch.toString() + "")//插入元素 入栈
                    i++//i+1
                }
                '-' -> if (i == 0) {//如果i为1位
                    postfix.append(0)//后加0
                    postfix.append(" ")
                    stack.push("(")//入栈
                    stack.push(ch.toString() + "")//顶部插入元素 入栈
                    i++//i+1
                } else {//否则会
                    while (!stack.isEmpty() && stack.peek() != "(")//栈不为空
                        postfix.append(stack.pop())//加弹出的栈
                    stack.push(ch.toString() + "")//顶部插入元素 入栈
                    i++//i+1
                }
                '×', '÷' -> {//运算符号
                    while (!stack.isEmpty() &&//条件 栈不为空
                        (stack.peek() == "×" || stack.peek() == "÷"))//符号
                        postfix.append(stack.pop())//加弹出的栈顶
                    stack.push(ch.toString() + "")//插入元素 入栈
                    i++//i+1
                }
                else -> if (i == 1 && infix.get(0) == '-') {//如果i为1且infix第一位为-符号
                    while (i < infix.length && ch >= '0' && ch <= '9' ||//i<infix的长度且ch>=0且<ch<=9
                        i < infix.length && ch == '.') {//i<infix长度且ch=.
                        postfix.append(ch)//在postfix后添加ch
                        i++//i+1
                        if (i < infix.length) ch = infix.get(i)//如果i<长度，赋予ch当前数据
                    }
                    postfix.append(" ")//postfix后添加
                    postfix.append('-')//添加-
                    stack.pop()
                    stack.pop()
                } else {
                    while (i < infix.length && ch >= '0' && ch <= '9' ||//i<infix且ch>=0，ch<=9
                        i < infix.length && ch == '.') {//i<infix长度且ch=.
                        postfix.append(ch)//添加数据
                        i++//i+1
                        if (i < infix.length) ch = infix.get(i)//如果i<infix长度，赋予ch数据
                    }
                    postfix.append(" ")//添加
                }
            }
        }
        while (!stack.isEmpty())//如果栈不为空
            postfix.append(stack.pop())//添加弹出的栈顶
        return postfix//返回 值
    }

    fun toValue(postfix: StringBuffer): Double {//创建toValue()函数
        val stack = Stack<Double>()//创建double类型的栈
        var value = 0.0//声明变量
        var j = 0
        var i = 0
        while (i < postfix.length) {//循环i<postfix
            j = i//把j的值赋予i
            var ch = postfix.get(i)//声明变量ch并赋值第i位
            if (ch >= '0' && ch <= '9' || ch == '.') {//如果ch是在0-9之间或为.
                value = 0.0//初始的值为0
                while (ch != ' ') {//ch非空
                    while (ch != ' ' && ch != '.') {//ch非空及ch不为.
                        value = value * 10.0 + (ch - '0').toDouble()//字符转化为数值
                        j++       //j+1
                        ch = postfix.get(++i)  //赋予ch值
                    }
                    if (ch != ' ' && ch == '.')   //如果ch不为空且为.
                        ch = postfix.get(++i)       //赋予ch值
                    while (ch != ' ' && i >= j + 1) {       //当ch非空，且i大于j+1
                        val valueBD = BigDecimal(value.toString())   //将String表示形式转换成BigDecimal形式
                        val chBD = BigDecimal(ch - '0')  //赋予chBD   BigDecimal第0位的值
                        val nBD = BigDecimal(Math.pow(10.0, (i - j).toDouble()))//10的幂
                        val temp = chBD.divide(nBD)//赋予temp  chBD除以nBD的值
                        value = valueBD.add(temp).toDouble()   //value值为 Double型的添加了temp值的valueBD值
                        ch = postfix.get(++i)  //ch的值赋予
                    }
                    stack.push(value) //入栈
                }
            } else {   //否则
                if (ch != ' ') { //如果ch非空
                    var y: Double = stack.pop()//声明y删除栈顶并返回
                    var x: Double = stack.pop() //声明x删除栈顶并返回
                    value = when (ch) {//赋值value   并判断
                        '+' -> x + y//为+时则运算x+y
                        '-' -> x - y//为-时则运算x-y
                        '×' -> x * y //为*时则运算x*y
                        '÷' -> x / y //为÷时则运算x/y
                        else -> 0.0 //否则为0
                    }
                    stack.push(value)//value的值入栈
                }
            }
            i++ //i+1
        }
        return stack.pop()//删除栈顶值并返回
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //绑定菜单项
        //nflate():参数1-通过哪个资源创建菜单      参数2-指定菜单项添加到哪一个Menu对象中
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    /**
     * 菜单项的点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //点击访问主页时
            R.id.visit_item -> {
                Toast.makeText(this, "你点击了访问主页", Toast.LENGTH_SHORT).show()
                //销毁当前Activity
                finish()
            }

            //点击退出时
            R.id.quit_item -> {
                Toast.makeText(this, "你点击了退出", Toast.LENGTH_SHORT).show()
                //销毁全部Activity


            }
        }
        return true
    }
}