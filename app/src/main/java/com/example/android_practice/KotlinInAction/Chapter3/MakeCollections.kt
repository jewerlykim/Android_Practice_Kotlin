package com.example.android_practice.KotlinInAction.Chapter3

fun main(args : Array<String>){
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    /* to는 언어가 제공하는 특별한 키워드가 아니라 일반함수이다. */
    /* 객체가 어떤 클래스에 속하는지 알아보기 */
    println(set.javaClass) // java에서 getClass()에 해당
    println(list.javaClass)
    println(map.javaClass)
    /* print out
    * class java.util.HashSet
      class java.util.ArrayList
      class java.util.HashMap */

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.maxOrNull()) // max가 maxOrNull로 바뀜
    // collection이 비었으면 null을 반환한다.
}