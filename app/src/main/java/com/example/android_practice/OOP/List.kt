package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempList = listOf(101, 102, 103, 104, 105)
    println(tempList)

    print("${tempList[0]} ")
    print("${tempList[1]} ")
    print("${tempList[2]} ")
    print("${tempList[3]} ")
    print("${tempList[4]} \n")

    print("${tempList.get(0)} ")
    print("${tempList.get(1)} ")
    print("${tempList.get(2)} ")
    print("${tempList.get(3)} ")
    print("${tempList.get(4)} \n")

    var index103 = tempList.indexOf(103)
    println(index103)

    var index99 = tempList.indexOf(99)
    println(index99)

    var subList = tempList.subList(0,3)
    println(subList)

    var tempMutableList = mutableListOf<Int>()
    tempMutableList.add(100)
    tempMutableList.add(100)
    tempMutableList.add(100)

    println(tempMutableList)
    tempMutableList.add(1, 1000)
    println(tempMutableList)

    tempMutableList.removeAt(1)
    println(tempMutableList)

    tempMutableList.set(2, 199)
    println(tempMutableList)

    tempMutableList.clear()
    println(tempMutableList)
}