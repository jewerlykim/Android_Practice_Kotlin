package com.example.android_practice.KotlinInAction.Chapter3

fun main(args : Array<String>){
    val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))

    val arrayList = arrayListOf<Int>(1, 2, 3)
    println(arrayList.joinToString(" "))

    println(listOf("one", "two", "eight").join(" "))
}

fun <T> Collection<T>.joinToString(
        separator : String = ", ",
        prefix : String = "",
        postfix : String = ""
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/* 문자열에 대해서만 만들기 */
fun Collection<String>.join (
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)