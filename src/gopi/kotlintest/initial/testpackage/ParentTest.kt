package gopi.kotlintest.initial.testpackage

open class Parent(){

    fun abc(){
        (this as? Child)?.def()
        print("list values are ${getList()}")
    }

    open fun getList(): MutableList<String> {
        return mutableListOf<String>("a", "b", "c")
    }
}

class Child(): Parent(){
    fun def(){
        var a: String? = null

    }

    override fun getList(): MutableList<String> {
        return mutableListOf<String>("d", "e", "f","g");
    }
}

fun main(args: Array<String>) {
    Child().abc()
}