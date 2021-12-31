package cn.itcast.jiaoben

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 17:31
 * 描述:
 */
class 重写属性 {
}


open class Parent() {
    open val name: String = "Bill"
        get() {
            println("获取Parent:name属性值")
            return field
        }
}
open class Child : Parent() {
    override var name: String = "MIKE"
        get() {
            println("获取Child:name属性值")
            return field
        }
        set(value) {
            field = value
            println("获取Child:name属性值被写入")
        }
}
fun main() {
    var child = Child()
    println(child.name)//"获取Child:name属性值"   "MIKE"
    child.name = "蛮吉"//"获取Child:name属性值被写入"
    println(child.name)//"获取Child:name属性值"   蛮吉
}