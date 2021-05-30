package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass : AbstractClass = SubClassAbstract()
    tempClass.generalMethod()
    tempClass.abstractMethod()
}

open abstract class AbstractClass {
    // 자식 클래스에서 그냥 사용할 수 있는 일반 메서드
    fun generalMethod(){
        println("일반 메서드")
    }

    // 자식 클래스에서 오버라이딩 해야 사용할 수 있는 추상 메서드
    open abstract fun abstractMethod()
}

class SubClassAbstract : AbstractClass(){
    override fun abstractMethod() {
        println("추상 메서드 구현")
    }

}