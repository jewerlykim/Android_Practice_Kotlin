package com.example.android_practice.KotlinInAction.Chapter2

fun main(args : Array<String>) {
    val number : Int = 150

    val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException(
                        "A percentage value must be between 0 and 100 : $number"
                )

    println("$percentage")
}