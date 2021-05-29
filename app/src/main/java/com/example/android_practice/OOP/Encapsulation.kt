package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempClass = Encapsulation()

    tempClass.intValue = 100
    println(tempClass.intValue)

    tempClass.strValue = "쥬얼리킴 최고에요 화이팅"
    println(tempClass.strValue)
}

class Encapsulation{
    // 외부의 접근을 막기위한 private 키워드
    // private 키워드 사용시 반드시 값을 초기화 시켜주어야 한다.
    private var memIntVar = 0
    private var memStrVar = ""

    var intValue : Int
        set(memIntVar) {
            this.memIntVar = memIntVar
        }
        get() = this.memIntVar

    var strValue : String
        set(memStrVar) {
            this.memStrVar = memStrVar
        }
        get() = this.memStrVar

}