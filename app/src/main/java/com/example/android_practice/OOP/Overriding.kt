package com.example.android_practice.OOP

fun main(args : Array<String>){
    var person : Animal = Person()
    person.walk()
    person.eat()
}

open class Animal {
    open fun walk(){
        println("네발로 걷기!")
    }

    open fun eat(){
        println("먹기!")
    }
}

open class Person : Animal(){
    override fun walk() {
        println("두발로 걷기")
    }

    override fun eat() {
        print("요리를 해서 ")
        super.eat()
    }
}