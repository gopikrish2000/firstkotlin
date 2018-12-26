package gopi.kotlintest.initial

class OuterClas {
    var name: String? = ""

    class InnerStaticClas {  // Inner Classes are by default static . So cannot access of the parent class
        fun sample() {
            val outerObj = OuterClas()
            outerObj.name = "asdf"
            println(outerObj)
        }
    }


    inner class InnerNestedClas(var age: Int?) {

        fun sampleMethod() {
            println(name + (age ?: 20))
        }
    }

    override fun toString(): String {
        return "OuterClas(name=$name)"
    }
}

open class OuterVisibility {
    open var name: String? = "name"    // public by default
    private var priName: String? = "priname"
    protected open var proName: String? = "protectedname"  // visible to the Base and the Derived class
    internal var internalName: String? = "internalName"  // visible inside the same module

}

class ChildVisibility : OuterVisibility() {
    override var proName: String? = "sdfw"
    override var name: String? = "sdfw11"

    fun sample() {
        val abc = "name is $name   ::: proName is  $proName ::: InternalName is $internalName "
        print(abc)  // private variable is not visible
    }
}

fun main(args: Array<String>) {
    OuterClas.InnerStaticClas().sample()
    OuterClas().InnerNestedClas(null).sampleMethod()

    val outerVisibilityObj = OuterVisibility()
    val childVisibilityObj = ChildVisibility()
    childVisibilityObj.sample()

    outerVisibilityObj.internalName  // only internal, public are accessible here ; Protected only accessible in Subclasses unlike java ( Module + subclasses )
    outerVisibilityObj.name

    childVisibilityObj.internalName
    childVisibilityObj.name
}