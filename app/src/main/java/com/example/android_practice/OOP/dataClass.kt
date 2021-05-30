package com.example.android_practice.OOP

fun main(args : Array<String>) {
    // 따로 초기화 안되어 있어서 생성시 값을 채워줘야 함
    var numClass = NumClass(n1 = 1, n2 = 9.9 , n3 = 8.7f)
    println("n1 : ${numClass.n1}")
    println("n2 : ${numClass.n2}")
    println("n3 : ${numClass.n3}")

    var fruitClass = FruitClass()
    println("fruit1 : ${fruitClass.fruit1}")
    println("fruit2 : ${fruitClass.fruit2}")
    println("fruit3 : ${fruitClass.fruit3}")

    // 초기화 되어있는 값 중 하나 변경하여 객체만듬
    fruitClass = FruitClass(fruit1 = "딸기")
    println("fruit1 : ${fruitClass.fruit1}")
    println("fruit2 : ${fruitClass.fruit2}")
    println("fruit3 : ${fruitClass.fruit3}")

    // 객체 copy
    var copyClass = fruitClass.copy()
    println("fruit1 : ${copyClass.fruit1}")
    println("fruit2 : ${copyClass.fruit2}")
    println("fruit3 : ${copyClass.fruit3}")

    //객체 copy 하면서 값 변경
    var copyClass2 = numClass.copy(n1=100)
    println("n1 : ${copyClass2.n1}")
    println("n2 : ${copyClass2.n2}")
    println("n3 : ${copyClass2.n3}")

}

//초기화 하지않은 data class
data class NumClass (var n1 : Int , var n2 : Double, var n3 :Float)

//초기화 한 data class
data class FruitClass (var fruit1 : String = "사과", var fruit2: String ="배", var fruit3: String ="바나나")