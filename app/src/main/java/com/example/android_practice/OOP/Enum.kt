package com.example.android_practice.OOP

fun main (args : Array<String>) {
    callFruitName(Fruit.APPLE)

    println(Fruit.APPLE)
    println(Fruit.BANANA)
    println(Fruit.ORANGE)

    println(Animal.LION)
    println(Animal.TIGER)
    println(Animal.DOG)
}

enum class Fruit {
    APPLE, BANANA, ORANGE
}

enum class Animal (val animal : String) {
    LION("사자"),
    TIGER("호랑이"),
    DOG("개")
}

fun callFruitName(fruit : Fruit) {
    when(fruit) {
        Fruit.APPLE -> println("사과")
        Fruit.BANANA  -> println("바나나")
        Fruit.ORANGE -> println("오렌지")
    }
}