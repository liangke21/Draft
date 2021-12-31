package cn.itcast.jiaoben.c

class Singleton private constructor(){
    var value:String?=null
    private object mHolder{val INSTANCE=Singleton()}
    companion object Factory{
        fun getInstance():Singleton{
            return mHolder.INSTANCE
          //  return Singleton() 返回不一样
        }
    }
}
fun main(){
    var obj1=Singleton.getInstance()
    var obj2=Singleton.getInstance()
    println(obj1)//Singleton@3d04a311
    println(obj2)//Singleton@3d04a311
}