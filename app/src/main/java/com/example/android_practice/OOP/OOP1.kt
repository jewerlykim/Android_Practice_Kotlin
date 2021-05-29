package com.example.android_practice.OOP

fun main(args : Array<String>){
    var oop1 = OOP1()

    var oop2 = OOP2(name = "Jewelry", age = 28)
    println("name is ${oop2.name}")
    println("age is ${oop2.age}")

    var oop3 = OOP3(name = "Muzi", age = 26)
    var oop4 = OOP3(name = "Lion", age = 27, "010-1234-1234")
    println("oop3 name is ${oop3.name}, age is ${oop3.age}")
    println("oop4 name is ${oop4.name}, age is ${oop4.age}, phone number is ${oop4.phoneNumber}")
}


class OOP3 constructor(name : String, age : Int) { // 추가 생성자 만들기
    var name = name
    var age = age;
    var phoneNumber = ""

    constructor(name: String, age: Int, phoneNumber : String) : this(name, age) {
        // 디폴트 생성자를 this(name, age)로 가져온다.
        this.phoneNumber = phoneNumber
    }
}

class OOP2 constructor(name : String, age : Int) { // default 생성자
    var name = name
    var age = age;
}

class OOP1 {
    init {
        println("init OOP 1 Class")
    }
}




