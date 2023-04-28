package com.example.firebaseapp_carol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var carmake:EditText
    lateinit var carmodel:EditText
    lateinit var carprice:EditText
    lateinit var btnphoto:Button
    lateinit var btndata:Button
    lateinit var btnview:Button

    //initialise firebase
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carmake = findViewById(R.id.edtmake)
        carmodel = findViewById(R.id.edtmodel)
        carprice = findViewById(R.id.edtprice)
        btnphoto = findViewById(R.id.btnphoto)
        btndata = findViewById(R.id.btndata)
        btnview = findViewById(R.id.btnview)

        //initialise firebase
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")

        btnphoto.setOnClickListener {}

        btndata.setOnClickListener {
            var carmake = carmake.text.toString().trim()
            var carmodel = carmodel.text.toString().trim()
            var carprice = carprice.text.toString().trim()

            //validate edittexts
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()){
                Toast.makeText(this, "Cannot Submit an Empty form", Toast.LENGTH_SHORT).show()
            }else{
                //saving info to firebase db
                var usercar =Car(carmake,carmodel,carprice)
                var  ref = FirebaseDatabase.getInstance().getReference().child("Cars")

                ref.setValue(usercar).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to Save Car INFO", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }

        btnview.setOnClickListener {

        }




    }
}