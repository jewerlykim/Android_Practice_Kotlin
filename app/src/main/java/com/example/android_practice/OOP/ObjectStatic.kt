package com.example.android_practice.OOP

/* java의 static과 비슷한 개념이라고 할 수 있다. object 키워드로 객체를 만들면
객체의 이름으로 바로 멤버나 메서드에 접근할 수 있다.*/

fun main(args : Array<String>){
    println(ObjectStatic.var1)
    ObjectStatic.method1()
}

object ObjectStatic{
    var var1 = "변수"

    fun method1(){
        println("메서드")
    }
}