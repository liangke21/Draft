package cn.itcast.jiaoben

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 16:28
 * 描述:
 */
class Person(name: String) {
    private var mName: String = name
    fun getName(): String = mName
}
class Persons() {
    fun addPerson(vararg persons: Person): List<Person> {
        val result = ArrayList<Person>()
        for (person in persons) {
            result.add(person)
        }
        return result
    }


}
fun main (){
    val p=Persons().addPerson(Person("1"),Person("2"),Person("3"))
    for (i in p){
        println(i.getName())

    }
}

fun add(){
    fun person(){}
    person()//这个函数只能在这个函数体使用
}

