package com.example.firebaseapp_carol

class Car {
    var car_make:String? = null
    var car_model:String? = null
    var car_price:String? = null

    constructor(car_make:String, car_model:String, car_price:String){
        this.car_model = car_model
        this.car_price = car_price
        this.car_make = car_make
    }
    constructor()
}