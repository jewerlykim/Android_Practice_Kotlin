package com.example.android_practice.OOP

/* array 만드는 방법
1 . arrayOf()라는 메서드를 이용하는 방법
2 . Array 클래스를 이용해서 만드는 방법 */

fun main(args : Array<String>){
    var temp = arrayOf(3, 6, 9, 12, 15)

    for(i in temp){
        println(i)
    }

    var temp2 = Array(5) { n -> n * 2 } // 람다로 바깥으로 뺄수있음

    for (i in temp2){
        println(i)
    }
}