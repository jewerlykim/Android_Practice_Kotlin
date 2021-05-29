package com.example.android_practice.HighorderFunction

fun main() {
//    val sum = {x : Int, y : Int -> x + y} // lambda
    val sum : (Int, Int) -> Int = {x, y -> x + y} // original format lambda
    println(sum(2,3))
    Calculator(2, 4) { a: Int, b: Int -> a + b }
    Calculator(3, 5) { a, b -> a + b } // 고차함수에
    // 타입이 정의되어 있는 경우 인자 타입을 뺄수도 있다.
    Calculator(4, 6) { a: Int, b: Int -> a + b } // 맨 마지막 인자가 람다일경우
    Calculator(5,7, ::sum)
    // 함수형 변수
    val minus : (Int, Int) -> Int = {a, b -> a-b}
    Calculator(5,2, minus)

    // 바깥으로 뺄수있다.
    Square(3) {a -> a * a}
    Square(3) {it * it}

    PrintInfo() {println("1.0")}
    PrintInfo { println("1.1") } // () 소괄호 생략 가능
    PrintInfo()
}


fun Calculator(a : Int, b : Int, p: (Int, Int) -> Int){ // Calculator는 고차함수
    println("$a, $b -> ${p(a, b)}")
}

fun Square(a : Int, p: (Int) -> Int){
    println("square $a -> ${p(a)}")
}

//fun PrintInfo(p : () -> Unit) {
//    print("Calculator Version : ")
//    p()
//    // Unit은 의미있는 반환값이 없는 경우, 명시하지 않으면 Default값. Java의 void와 비슷. 다름하지만
//}

fun PrintInfo(p : (() -> Unit)? = null) { // nullable로 할수도 있음
    print("Calculator Version : ")
    p?.invoke()?:println("no version")
    // Unit은 의미있는 반환값이 없는 경우, 명시하지 않으면 Default값. Java의 void와 비슷. 다름하지만
}


fun sum(a : Int, b : Int) = a + b
