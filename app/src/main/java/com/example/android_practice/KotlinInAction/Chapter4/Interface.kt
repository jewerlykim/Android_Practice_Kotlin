package com.example.android_practice.KotlinInAction.Chapter4

interface Clickable {
    fun click()
}

class Button : Clickable {
    override fun click() {
        println("I was clicked")
    }
}

fun main(array: Array<String>){
    Button().click()
}