package cn.itcast.jiaoben.d

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 19:10
 * 描述:
 */
enum class Direction private constructor(val d: Int) {
    NORTH(1), SOUTH(2), WEST(3), EAST(4);

    override fun toString(): String {
        return d.toString()
    }

}
/*fun main(){
    val direction1:Direction=Direction.NORTH
    val direction2:Direction=Direction.WEST
    println(direction1.name)//NORTH
    println(direction2.ordinal)//2   获取索引从0开始
    println(Direction.valueOf("SOUTH"))//2
    for (i in Direction.values()){
        println(i)//1 2 3 4
    }
}*/

class Myclass() {
    fun Instansce() {
        println("我是内部成员函数")
    }


}

fun Myclass.Instansce() {
    println("我是顶层函数")
}
/*fun main(){
    println(Myclass().Instansce())//内部成员函数优先级高,通过扩展函数无法覆盖内部成员函数
}*/


open class Child {
    var name: String = "MIKE"
        get() {
            println("获取Child:name属性值")
            return field
        }
        set(value) {
            field = value
            println("获取Child:name属性值被写入")
        }
}

data class User(var name: String, var age: Int) {
}
/*
fun main() {
    var u = User("蛮吉", 23)
    println(u)//User(name=蛮吉, age=23)
    println(u.name)//蛮吉
    u.name="满大人"
    println(u.name)//"满大人"
   val(name,age)=u
    println("$name ::  $age")

}*/


sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun main(){
    val const = Const(100.0)
    println("RS "+eval(NotANumber))

}
fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}



