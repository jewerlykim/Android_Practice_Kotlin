package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass1 = SubClass2()
    println("tempClass1.memVar : ${tempClass1.memVar1}")

    var tempClass2 = SubClass2(20)
    println("tempClass2.memVar : ${tempClass2.memVar1}")
}

open class SuperClass2 constructor(memVar1 : Int){
    var memVar1 = memVar1
}

class SubClass2 : SuperClass2 {
    constructor() : super(10) // 파라미터가 없는 생성자 이용할 시 10이 할당
    constructor(memVar1: Int) : super(memVar1) // 파라미터가 있는 생성자 이용시 넣어준 값을 할당
}