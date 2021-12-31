package cn.itcast.jiaoben.d

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/27 11:08
 * 描述:
 */
class Generic<T> {
    var key: T? = null


    constructor(key: T?) {
        this.key = key
    }
}


fun main() {

    val strGeneric = Generic<String>("你好")
    val key1 = strGeneric.key
    println(key1)

    val intGeneric = Generic<Int>(90)
    val key2 = intGeneric.key
    println(key2)
    intGeneric.key=30
    println(intGeneric.key)

    val generic=Generic("你好")
    val key3=generic.key
    println(key3)
}