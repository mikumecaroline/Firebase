package com.example.firebaseapp_carol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var edtEmail:EditText
    lateinit var edtpass:EditText
    lateinit var btnlog:Button
    lateinit var btncreateacc:Button

    //initialise firebase
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmail = findViewById(R.id.edtemail)
        edtpass = findViewById(R.id.edtpass)
        btnlog = findViewById(R.id.btnlogin)
        btncreateacc = findViewById(R.id.btnreg)

        auth = FirebaseAuth.getInstance()

        btnlog.setOnClickListener {
            var email = edtEmail.text.toString().trim()
            var password = edtpass.text.toString().trim()

            //validate inputs
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the inputs is empty", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()

                        var  gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
    }
}