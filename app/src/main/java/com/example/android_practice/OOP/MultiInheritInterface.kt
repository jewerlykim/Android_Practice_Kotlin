package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass1 : Interface1 = TempClass()
    tempClass1.generalMethod1()
    tempClass1.abstractMethod1()

    var tempClass2 : Interface2 = TempClass()
    tempClass2.generalMethod2()
    tempClass2.abstractMethod2()
}

interface Interface1 {
    fun generalMethod1(){
        println("Interface1에서 구현된 일반 메서드입니다.")
    }
    fun abstractMethod1()
}

interface Interface2 {
    fun generalMethod2(){
        println("Interface2에서 구현된 일반 메서드입니다.")
    }
    fun abstractMethod2()
}

class TempClass : Interface1, Interface2 {
    override fun abstractMethod1() {
        println("TempClass에서 구현된 Interface1의 추상 메서드입니다.")
    }

    override fun abstractMethod2() {
        println("TempClass에서 구현된 Interface2의 추상 메서드입니다.")
    }

}