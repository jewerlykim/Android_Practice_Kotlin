package com.example.android_practice.OOP

/* 추상클래스나 인터페이스를 따로 생성하지 않고 바로 객체로 만들 수 있다. */

fun main(args : Array<String>){
    var temp1 = object : AbstractClassObject(){
        override fun abstractMethod() {
            println("abstract method 구현")
        }
    }

    var temp2 = object : InterfaceObject {
        override fun interfaceMethod() {
            println("interface method 구현")
        }
    }

    temp1.abstractMethod()
    temp2.interfaceMethod()

}

abstract class AbstractClassObject {
    abstract fun abstractMethod()
}

interface InterfaceObject {
    fun interfaceMethod()
}