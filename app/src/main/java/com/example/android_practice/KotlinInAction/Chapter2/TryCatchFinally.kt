package com.example.android_practice.KotlinInAction.Chapter2

import java.io.BufferedReader
import java.io.StringReader

fun main(args : Array<String>){
//    val reader = BufferedReader(StringReader("239"))
    val reader = BufferedReader(StringReader("not a number"))
//    println(readNumber(reader = reader))
    readNumber(reader)
}

//fun readNumber(reader : BufferedReader) : Int? {
//    return try {
//        val line = reader.readLine()
//        Integer.parseInt(line)
//    } catch (e : NumberFormatException){
//        null
//    } finally {
//        reader.close()
//    }
//}

/* try를 식으로 활용하기 */
fun readNumber(reader : BufferedReader) {
    val number = try { // if와 달리 try는 반드시 중괄호로 둘러싸야한다.
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException){
//        return
        null // return 하면 바로 종료. null 반환하면 다음으로 넘어감
    }
    println(number)
}