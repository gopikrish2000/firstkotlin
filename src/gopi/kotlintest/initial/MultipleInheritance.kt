package gopi.kotlintest.initial

open class Bird {
    open fun fly() {
        println("Bird is flying")
    }
}

interface FlyInterface {
    var id: Int  // abstract variable
    val abc:Int  // cannot assign value in interface.
    fun sampleAbstract()
    fun fly() {
        println("Inside FlyInterface")
    }
}

open class Animal {
    fun fly() {
        println("Animal can also fly")
    }
}

class MultipleInheritanceTest : Bird(),FlyInterface {  // but kotlin doesn't support multiple inheritance.
    override val abc = 22
    override var id: Int

        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun sampleAbstract() {
    }

    override fun fly() {  // u must override as there is conflict.
        super<Bird>.fly()
        super<FlyInterface>.fly()
        println("Calling both Class n interface")
    }
}

fun main(args: Array<String>) {
    val obj = MultipleInheritanceTest()
    obj.fly()
}