package cn.itcast.jiaoben.c

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 14:01
 * 描述: 函数默认值
 */
class Customer(val customerName: String = "满大人", var value: Float = 45.4f,var add: String="我是多出来的") {    //主构造函数
    init{
        println(customerName+value)
    }
    //第一个次构造函数
    constructor(name: String = "狐妖小红娘" ,value:String="第二部",add:String="我是多出来的") : this("面瓜",25.3f ) {//第二构造函数
        println(name+value)
    }
    //第二个次构造函数
    constructor(name: String = "狐妖小红娘" ,value:String="第二部") : this("王权富贵",25.3f ) {//第二构造函数
        println(name+value)
    }
    //第三个次构造函数
    constructor(name: String = "魁拔") : this("蛮吉", 23.5f) {//第二构造函数
        println(name)
    }

    fun add(name: String = "hello"): String {//函数
        return name
    }
}
fun main() {
   println(Customer().customerName) //默认先拿到最少次函数的返回值/ "蛮吉", 23.5f  "魁拔" "蛮吉"
    println(Customer().value)//"蛮吉", 23.5f  "魁拔" 23.5f
    println(Customer().add())//"蛮吉", 23.5f  "魁拔" "hello"
}