package com.example.android_practice.OOP

/* Iterator 컬렉션을 이용해야만 객체를 가져올 수 있다. */

fun main(array : Array<String>){
    var tempSet = setOf(100, 200, 300, 400, 500)
    println(tempSet)

    var tempItor = tempSet.iterator()

    while (tempItor.hasNext()){
        print("${tempItor.next()} ")
    }
    println()

    var tempMutableSet = mutableSetOf<Int>()
    tempMutableSet.add(10)
    tempMutableSet.add(20)
    tempMutableSet.add(30)
    println(tempMutableSet)

    tempMutableSet.remove(20)
    println(tempMutableSet)
}