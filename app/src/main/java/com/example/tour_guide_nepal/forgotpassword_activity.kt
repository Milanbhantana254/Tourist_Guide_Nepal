package com.example.tour_guide_nepal

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*


class forgotpassword_activity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private lateinit var et_forget_email: TextView
    private lateinit var btn_submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        btn_submit = findViewById(R.id.btn_submit)
        et_forget_email = findViewById(R.id.et_forget_email)
        mAuth = FirebaseAuth.getInstance()

        btn_submit.setOnClickListener {
            val email = et_forget_email.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Enter your email!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth!!.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@forgotpassword_activity, "Check email to reset your password!", Toast.LENGTH_SHORT).show()
                            updateUI()
                        } else {
                            Toast.makeText(this@forgotpassword_activity, "No user found with this email!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }

    private fun updateUI() {
        val intent = Intent(this@forgotpassword_activity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}








