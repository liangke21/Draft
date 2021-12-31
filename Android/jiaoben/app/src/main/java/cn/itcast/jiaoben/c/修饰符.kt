package cn.itcast.jiaoben

/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/26 17:07
 * 描述:
 */
class 修饰符 {
}
open class Outer(){

    private val a=1
    protected open val b=2
    protected open fun add(){}
}

open class Subclass:Outer(){
    override val b: Int
        get() = super.b
//final 阻止子类重写
  final  override fun add() {
        super.add()
    }
}

class sss:Subclass(){

}