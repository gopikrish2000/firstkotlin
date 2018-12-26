package gopi.kotlintest.nextlevel

import gopi.kotlintest.initial.helpers.ifNullReturn

class HTML()
class BODY()

class PairToHashMapConvertor {

    inline fun <reified B> getData(vararg pairs: Pair<String, Any>) {
        val dataMapOfPairs = mapOf(*pairs)
        /*for (pair in pairs){
        }*/
//        val className =
        pairs.forEach { println(" class name is ${B::class.java}  with Follow ${it.first} :: ${it.second}") }
    }

    fun html( block: () -> Unit): HTML {
        block()
        return HTML()
    }

    fun body(block: HTML.() -> Unit): BODY{
        val body = BODY()
        HTML().block()
        return body
    }

    fun checkNullHandling(input: String?){
        ifNullReturn(input)()   // This is quite wrong as only in inline functions non linear return can happen.
        println(input!!.plus("ADD"))
    }

    inline fun functionChecker(input: String?, block: () -> Unit?) {
        block()
        println("This line is not printed as return is called in the block function.")
    }
}

fun main(args: Array<String>) {
    val obj = PairToHashMapConvertor()
    obj.getData<Int>("firstParam" to 22 , "secondParam" to 34.0f)

    for(i in 0 until 1){
        println(i)
    }

//    obj.checkNullHandling(null)
//    obj.checkNullHandling("ereww")

    obj.functionChecker("sdf"){ println("This is non linear execution flow "); return }

    obj.html({
        println("sdf");
    })

}