package com.example.android_practice.OOP

/* size - 배열의 크기
* get, set method
* copyOf method */

fun main(args : Array<String>){
    var tempArray = arrayOf(30, 20, 40, 50, 10)

    println("size : ${tempArray.size}")

    var temp1 = tempArray[0]
    println("tempArray[0] : $temp1")
    var temp2 = tempArray.get(0)
    println("tempArray.get(0) : ${tempArray.get(0)}")

    for (i in tempArray){
        print("$i")
    }
    println()

    tempArray.set(0, 31)
    tempArray[2] = 41

    for(i in tempArray){
        print("$i")
    }
    println()

    var copyArray1 = tempArray.copyOf()
    for (i in copyArray1){
        print("$i")
    }
    println()

    var copyArray2 = tempArray.copyOf(2)
    for (i in copyArray2){
        print("$i")
    }
    println()

    var copyArray3 = tempArray.copyOfRange(2,5)
    for (i in copyArray3){
        print("$i")
    }
    println()

    var sortArray = tempArray.sortedArray()
    for (i in sortArray){
        print("$i")
    }
    println()

    var reverseArray = sortArray.reversedArray()
    for (i in reverseArray){
        print("$i")
    }
    println()
}
