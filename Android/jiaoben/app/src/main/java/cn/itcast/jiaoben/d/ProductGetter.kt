package cn.itcast.jiaoben.d

import java.util.*
import kotlin.collections.ArrayList


/**
 * 作者: QQ群:799145059
 * 时间: 2021/4/27 14:07
 * 描述:74
 */
class ProductGetter<T> {
    private val random = Random()
    private var product: T? = null

    val list = ArrayList<T>()
    fun addProduct(t: T) {
        list.add(t)
    }

    //泛型必须私有化  才能返回
    fun getProduct(): T? {
        product = list[random.nextInt(list.size)]
        return product
    }
}

fun main() {
    //泛型在创建对象时候 来指定数据类型,没有指定类型,默认Objet
    val stringProductGetter = ProductGetter<String>()
    var serProduct = arrayOf("苹果手机", "华为手机", "OPPO手机", "扫地机器人")
    serProduct.forEach { a -> stringProductGetter.addProduct(a) }
    val product = stringProductGetter.getProduct()
    println("恭喜你抽中了$product")
    println("-----------------------------------------------")
    val intProductGetter = ProductGetter<Int>()
    val intProduct = intArrayOf(100, 200, 300, 400, 78)
    for (i in intProduct) {
        intProductGetter.addProduct(i)
    }
    println("恭喜你抽中了:${intProductGetter.getProduct()}元")
}