package com.example.android_practice.OOP

/* object는 따로 이름이 존재하지 않는 개체를 의미한다고 생각하면 된다. */


fun main(args : Array<String>){
    var obj1 = object {
        var temp1 = "hi"
        var temp2 = 7
        var temp3 = 1.1

        fun objectMethod(){
            print("object method")
        }
    }

    println(obj1.temp1)
    println(obj1.temp2)
    println(obj1.temp3)
    obj1.objectMethod()
}