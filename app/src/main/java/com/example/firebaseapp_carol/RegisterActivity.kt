package com.example.firebaseapp_carol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var edtfullnamereg:EditText
    lateinit var edtemailreg:EditText
    lateinit var edtpasswordreg:EditText
    lateinit var btncreatereg:Button

    //initialise firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edtfullnamereg = findViewById(R.id.edtnamereg)
        edtemailreg = findViewById(R.id.edtemailreg)
        edtpasswordreg = findViewById(R.id.edtPassreg)
        btncreatereg = findViewById(R.id.btncreatereg)

        //initialise firebase again
        auth = FirebaseAuth.getInstance()

        btncreatereg.setOnClickListener {
            var name = edtfullnamereg.text.toString().trim()
            var email = edtemailreg.text.toString().trim()
            var password = edtpasswordreg.text.toString().trim()

            //validate your input
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_SHORT).show()
            }else{
                //create a user in firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                        var  gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    }else{
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    }
                }


                }



        }
    }
}