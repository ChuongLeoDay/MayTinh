package com.example.maytinh

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


@Suppress("USELESS_CAST")
public class MainActivity : AppCompatActivity() {

    var TinhToan: String = "";

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idSo1 = findViewById<Button>(R.id.btn1)
        val idSo2 = findViewById<Button>(R.id.btn2)
        val idSo3 = findViewById<Button>(R.id.btn3)
        val idSo4 = findViewById<Button>(R.id.btn4)
        val idSo5 = findViewById<Button>(R.id.btn5)
        val idSo6 = findViewById<Button>(R.id.btn6)
        val idSo7 = findViewById<Button>(R.id.btn7)
        val idSo8 = findViewById<Button>(R.id.btn8)
        val idSo9 = findViewById<Button>(R.id.btn9)
        val idSo0 = findViewById<Button>(R.id.btn0)

        val result = findViewById<TextView>(R.id.textResult)

        val idCong = findViewById<Button>(R.id.btnCong)
        val idTru = findViewById<Button>(R.id.btnTru)
        val idNhan = findViewById<Button>(R.id.btnNhan)
        val idChia = findViewById<Button>(R.id.btnChia)
        val idPhanTram = findViewById<Button>(R.id.btnPhanTram)
        val idBang = findViewById<Button>(R.id.btnBang);

        fun showAlertDialog(message: String) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, id ->
                    // Do nothing
                }
            val alert = builder.create()
            alert.show()
        }

        fun calculateResult(expression: String): String {
            try {
                val context = Context.enter()
                context.optimizationLevel = -1
                val scope = context.initStandardObjects()
                val result = context.evaluateString(scope, expression, "expression", 1, null)
                return result.toString()
            } catch (e: Exception) {
                showAlertDialog("Bạn đang nhập sai biểu thức")
                return ""
            } finally {
                Context.exit()
            }
        }


        fun onClickNumber(view: View) {

            TinhToan = TinhToan + (view as Button).text
            result.setText(TinhToan)
        }

        fun onClickRegex(view: View) {
            if ((view as Button).id == R.id.btnCong) {
                TinhToan = TinhToan + "+"

            }
            if ((view as Button).id == R.id.btnTru) {
                TinhToan = TinhToan + "-"

            }
            if ((view as Button).id == R.id.btnNhan) {
                TinhToan = TinhToan + "*"

            }
            if ((view as Button).id == R.id.btnChia) {
                TinhToan = TinhToan + "/"
            }
            if ((view as Button).id == R.id.btnPhanTram) {
                TinhToan = TinhToan + "%"
            }

            if ((view as Button).id == R.id.btnBang) {
                val final =  calculateResult(TinhToan);
                TinhToan = final;
            }

            result.setText(TinhToan)
        }


        idSo1.setOnClickListener {
            onClickNumber(it)
        }
        idSo2.setOnClickListener {
            onClickNumber(it)
        }
        idSo3.setOnClickListener {
            onClickNumber(it)
        }
        idSo4.setOnClickListener {
            onClickNumber(it)
        }
        idSo5.setOnClickListener {
            onClickNumber(it)
        }
        idSo6.setOnClickListener {
            onClickNumber(it)
        }
        idSo7.setOnClickListener {
            onClickNumber(it)
        }
        idSo8.setOnClickListener {
            onClickNumber(it)
        }
        idSo9.setOnClickListener {
            onClickNumber(it)
        }
        idSo0.setOnClickListener {
            onClickNumber(it)
        }

        idCong.setOnClickListener {
            onClickRegex(it)
        }
        idTru.setOnClickListener {
            onClickRegex(it)
        }
        idNhan.setOnClickListener {
            onClickRegex(it)
        }
        idChia.setOnClickListener {
            onClickRegex(it)
        }
        idPhanTram.setOnClickListener {
            onClickRegex(it)
        }

        idBang.setOnClickListener {
            onClickRegex(it)
        }

    }


}
