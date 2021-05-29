package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass = SubClass()
    println("temp.subMemeberVar : ${tempClass.subMemberVar}")
    tempClass.subClassMethod()
    println("temp.superMemberVar : ${tempClass.superMemberVar}")
    tempClass.superClassMethod()
}

open class SuperClass{ // open이 없으면 final이라고 인식한다. final은 상속받을 수 없음.
    var superMemberVar = 5

    fun superClassMethod(){
        println("SuperClass Method")
    }
}

class SubClass : SuperClass {
    var subMemberVar = 10

    constructor():super() // 부모클래스를 호출하는 생성자 이렇게 하거나 위에 소괄호해주거나

    fun subClassMethod(){
        println("SubClass method")
    }
}