/* 클래스의 이름 변경하기
* @JvmName 어노테이션 추가하기 패키지 전에 선언해야함
* @file:JvmName("StringFucntions") */

package com.example.android_practice.KotlinInAction.Chapter3

fun main(args : Array<String>){
    val list = listOf(1, 2, 3)
    /* 호출할 때 모든 인자를 쓸 수도 있고, 일부를 생략할 수도 있다. */
    println(joinToStringDefault(list, "; ", "(", ")"))
    println(joinToStringDefault(list, ", ", "", ""))
    println(joinToStringDefault(list))
    println(joinToStringDefault(list, "; "))
    // 이름 붙인 인자 사용하는 경우는 순서를 바꿔도 되고 중간 생략해도 된다.
    println(joinToStringDefault(list, postfix = "$$ ", separator = "> ", prefix = "(("))

}

/* java에서는 디폴드 파라미터 값이 없음
@JvmOverloads 어노테이션을 붙이면 자동으로 맨 마지막 파라미터로부터
파라미터 하나씩 생략한 오버로딩된 함수를 만들어줌. 그리고 생략된 값에
디폴트 값을 넣어줌*/
@JvmOverloads
fun <T> joinToStringDefault( // Default 값을 지정해준 함수
        collection: Collection<T>,
        separator : String = ", ",
        prefix : String = "",
        postfix : String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}