package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass : InterfaceExample = GeneralClass()
    useInterfaceExample(tempClass)
}

interface InterfaceExample {
    fun generalMethod(){
        println("InterfaceExample에서 구현된 일반 메서드 입니다.")
    }
    fun abstractMethod() // 이렇게 하면 override 해야
    fun abstractMethod2(){
        // 이렇게 하면 override 할 필요가 없고
    }
}

class GeneralClass : InterfaceExample{
    override fun abstractMethod() {
        println("GeneralClass에서 구현된 추상 메서드입니다.")
    }
}

fun useInterfaceExample(interfaceExample: InterfaceExample){
    interfaceExample.generalMethod()
    interfaceExample.abstractMethod()
}