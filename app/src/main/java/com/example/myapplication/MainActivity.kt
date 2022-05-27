package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AndroidCalculator.Calculator


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //将当前正在创建的Activity添加到集合里


        //绑定资源
        val BtnJMP = findViewById(R.id.btn_jsq) as Button

        //BtnJMP按钮的监听事件
        BtnJMP.setOnClickListener {
            //跳转到Calculator（显示）
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
    }

    /**
     * 销毁
     */
    override fun onDestroy() {
        super.onDestroy()
        //从集合中移除一个马上要销毁的Activity

    }
}
