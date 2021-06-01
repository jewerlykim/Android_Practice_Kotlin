package com.example.android_practice.OOP

fun main(args : Array<String>){
    var tempMap = mapOf("key1" to 101, "key2" to 102, "key3" to 103)
    println(tempMap)

    println(tempMap.get("key1"))
    println(tempMap.get("key2"))
    println(tempMap.get("key3"))

    println(tempMap["key1"])
    println(tempMap["key2"])
    println(tempMap["key3"])

    var tempMutableMap = mutableMapOf<String, Any?>()
    tempMutableMap.put("key1", 100)
    tempMutableMap.put("key2", 99.9)
    tempMutableMap.put("key3", "문자열")

    println(tempMutableMap)
    println(tempMutableMap.get("key1"))
    println(tempMutableMap.get("key2"))
    println(tempMutableMap.get("key3"))

    tempMutableMap.set("key3", "나는 바보")
    println(tempMutableMap)

    tempMutableMap.remove("key3")
    println(tempMutableMap)
}