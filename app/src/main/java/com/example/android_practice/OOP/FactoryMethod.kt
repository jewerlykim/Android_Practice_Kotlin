package com.example.android_practice.OOP

/* 팩토리 메서드란 메서드에서 객체를 생성해서 리턴하는 것을 의미한다.
* companion object 사용 */

fun main(args : Array<String>){
    var temp = FactoryClass.create()
}

class FactoryClass {
    companion object{
        fun create() : FactoryClass {
            return FactoryClass()
        }
    }
}