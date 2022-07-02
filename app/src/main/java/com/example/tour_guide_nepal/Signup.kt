package com.example.tour_guide_nepal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.Repository.UserRepository
 
import com.example.tour_guide_nepal.termsandservices.front_terms_and_services

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Signup : AppCompatActivity() {
 
    private lateinit var btnsignup: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

 
    private lateinit var etname: TextView
    private lateinit var etphone: TextView
    private lateinit var etpass: TextView
    private lateinit var etconfigpass: TextView
    private lateinit var eetemail: TextView
    private lateinit var btnlog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
 
        auth = FirebaseAuth.getInstance()
 
        etname = findViewById(R.id.etname)
        eetemail = findViewById(R.id.etemail)
        etpass = findViewById(R.id.etpass)
        etconfigpass = findViewById(R.id.etconpass)
        etphone = findViewById(R.id.etphone)
        btnsignup = findViewById(R.id.btnsignup)
        btnlog = findViewById(R.id.btnlog)
        db= FirebaseFirestore.getInstance()





        btnsignup.setOnClickListener {


            if (validatesignup()) {

                val FullName = etname.text.toString()
 
                val email = eetemail.text.toString()
 
                val phone = etphone.text.toString()
                val password = etpass.text.toString()

                val users = hashMapOf(
                    "Name" to FullName,
                    "Phone" to phone,
                    "email" to email
                )
                val Users=db.collection("USERS")
                val query = Users.whereEqualTo("email", email).get()
                    .addOnSuccessListener { tasks->
                        if(tasks.isEmpty)
                        {
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this){ task->
                                    if(task.isSuccessful)
                                    {
                                        Users.document(email).set(users)

                                        val intent=Intent(this,front_terms_and_services::class.java)
                                        intent.putExtra("email",email)

                                        startActivity(intent)
                                        finish()
                                    }
                                    else
                                    {
                                        Toast.makeText(
                                            this,
                                            "Authentication Failed",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                        }
                        else
                        {
                            Toast.makeText(this, "User Already Registered", Toast.LENGTH_LONG).show()
                            val intent= Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    }

        val actionBar = supportActionBar
        actionBar!!.hide()

                val confirmPassword = etconfigpass.text.toString()
                if (eetemail.text.toString().isEmpty()) {
                    eetemail.error = "Please enter email"
                    eetemail.requestFocus()

                }

                if (!Patterns.EMAIL_ADDRESS.matcher(eetemail.text.toString()).matches()) {
                    eetemail.error = "Please enter valid email"
                    eetemail.requestFocus()

                }
                if (etphone.text.toString().isEmpty()) {
                    etphone.error = "Please enter phone number"
                    etphone.requestFocus()

                }
                if (etname.text.toString().isEmpty()) {
                    etname.error = "Please enter your full name"
                    etname.requestFocus()

                }

                if (etpass.text.toString().isEmpty()) {
                    etpass.error = "Please enter password"
                    etpass.requestFocus()

                }
                if (password != confirmPassword) {
                    etpass.error = "Password does not match"
                    etpass.requestFocus()
                    return@setOnClickListener
                } else {
                    val user =
                        User(

                            fullname = FullName,
 
                            email = email,
 
                            phone = phone,
                            password = password
                        )
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val userRepository = UserRepository()
                            val response = userRepository.registerUser(user)
                            if (response.success == true) {
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(
                                        this@Signup,
                                        "signup successfully", Toast.LENGTH_SHORT

                                    ).show()
                                    getSharedPreferences(
                                        "shared_preference",
                                        Context.MODE_PRIVATE
                                    ).edit().putBoolean("isLoggedIn", true).apply()
                                }
                            }
                        } catch (ex: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@Signup,
                                    ex.message, Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }


                }
            }





            btnlog.setOnClickListener {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }




    private fun sanitize(input: EditText): String {
        return input.text.toString().trim(' ')
    }


    private fun validatesignup(): Boolean {

 
        var valid = true
        eetemail.error = null
        etname.error = null
        etpass.error = null
        etconfigpass.error = null
        etphone.error = null


        if (sanitize(eetemail as EditText).isEmpty()) {
            eetemail.error = "Email can not be empty"
            valid = false
        }


        if (sanitize(etname as EditText).isEmpty()) {
            etname.error = "Fullname can not be empty"
            valid = false
        }
        if (sanitize(etpass as EditText).isEmpty()) {
            etpass.error = "Password can not be empty"
            valid = false
        }
        if (sanitize(etconfigpass as EditText).isEmpty()) {
            etconfigpass.error = "confirm Password can not be empty"
            valid = false
        }
        if (sanitize(etphone as EditText).isEmpty()) {
            etphone.error = "phone number can not be empty"
            valid = false
        }
 


        return valid
    }


}
