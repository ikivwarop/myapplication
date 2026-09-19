package com.example.myapplication.auth
import com.example.myapplication.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.LinearLayout
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class VerificationActivity : AppCompatActivity() {

    private lateinit var otp1: EditText
    private lateinit var otp2: EditText
    private lateinit var otp3: EditText
    private lateinit var otp4: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        findViewById<ImageView>(R.id.backarrow).setOnClickListener { finish() }

        otp1 = findViewById(R.id.otp1)
        otp2 = findViewById(R.id.otp2)
        otp3 = findViewById(R.id.otp3)
        otp4 = findViewById(R.id.otp4)


        val nextButton = findViewById<LinearLayout>(R.id.next_button)

        moveToNext(otp1, otp2)
        moveToNext(otp2, otp3)
        moveToNext(otp3, otp4)

        nextButton.setOnClickListener {
            val otp = otp1.text.toString() +
                    otp2.text.toString() +
                    otp3.text.toString() +
                    otp4.text.toString()

                    if (otp.length == 4) {

                        val intent =Intent(this,SelectLocationActivity::class.java)
                        startActivity(intent)

                    }else {
                        Toast.makeText(this, "please enter the four digit code", Toast.LENGTH_SHORT
                        ).show()
                    }
        }
        val resendCode = findViewById<TextView>(R.id.resend_code)

        resendCode.setOnClickListener {

            Toast.makeText(this,
                    "A new verification code has been sent.",
                    Toast.LENGTH_SHORT
            ).show()
        }
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long){
                resendCode.isEnabled = false
                resendCode.text = "Resend Code (${millisUntilFinished / 1000}s)"

            }
            override fun onFinish() {
                resendCode.isEnabled = true
                resendCode.text = "Resend Code"

            }
        }.start()



    }
    private fun moveToNext(current: EditText, next: EditText){
        current.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ){
            }

            override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
            ){
                if(current.text.toString().length ==1){
                    next.requestFocus()
                }

        }

            override fun afterTextChanged(s: Editable?) {

            }

        })

    }
}