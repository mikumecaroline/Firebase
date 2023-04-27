package com.example.firebaseapp_carol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var edt_user_inp:EditText
    lateinit var btn_save_data:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edt_user_inp= findViewById(R.id.edtdata)
        btn_save_data = findViewById(R.id.btnsave)

        //initialise
        var database = FirebaseDatabase.getInstance()
        var  databaseRef = database.reference

        btn_save_data.setOnClickListener {
            var user_data = edt_user_inp.text.toString().trim()
            //Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseRef.setValue(user_data)
        }

    }
}