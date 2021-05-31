package com.example.android_practice.OOP

fun main (args : Array<String>) {

    var temp1 = OuterClass();
    var temp2 = temp1.InnerClass();

    println("OuterClass.outerVar : ${temp1.outerVar}")
    // OuterClass 객체에서 InnerClass 변수 사용 불가
//    println("OuterClass.innerVar : ${temp1.innerVar}")

    println("InnerClass.innerVar : ${temp2.innerVar}")
    // InnerClass 객체에서 OuterClass 변수 사용 불가
    //println("InnerClass.outerVar : ${temp2.outerVar}")

}

class OuterClass {
    var outerVar = "아우터 변수"

    inner class InnerClass {
        var innerVar = "이너 변수"

        fun innerMethod() {
            println("innerVar : ${innerVar}")
            // outer 에 선언된 메서드에서 innerClass의 변수 사용 가능
            println("outerVar : ${outerVar}")
        }
    }

    fun outerMethod() {
        // outer 에 선언된 메서드에서 innerClass의 변수 사용 불가
        //println("innerVar : ${innerVar}")
        println("outerVar : ${outerVar}")
    }
}