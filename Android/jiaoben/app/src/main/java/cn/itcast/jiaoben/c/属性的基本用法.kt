package cn.itcast.jiaoben.c

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 15:49
 * 描述:
 */
class Customer2 {
    //只读
    val name: String
        get() = "蛮吉"
    var v: Int = 20
    //读写属性
    var value: Int = 0
        get()=v
        set(value) {
            println("value属性值")
            field = value
            println(field)
        }
}
fun main() {
    println(Customer2().name)//蛮吉
    println(Customer2().v)//20
    println(Customer2().value)//20
    val a = Customer2()
    a.value = 40//"value属性值"  40
}