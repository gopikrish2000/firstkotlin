package gopi.kotlintest.initial

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other


open class FirstClass {   // by default classes, variables are final . So use open to make it extendable.
    //    abstract var ageAbstract: Int ;  // abstract variable is allowed in kotlin read more.
    open var age: Int = 0;  // abstract variable is allowed in kotlin read more.
    var name: String? = null;  // regardless of variable ? or not we have to initialize the values.

    constructor(age: Int, name: String?) {   // This is secondary constructor.
        this.age = age
        this.name = name
    }

    constructor(name: String?) {
        this.name = name
    }

    override fun toString(): String {
        return "FirstClass(age=$age, name=$name)"
    }
}

// This is primary constructor.
class SecondClass(override var age: Int, name: String? = null, val marks: Int) : FirstClass(age, name) {   // always mark variables as var/ val in the constructors otherwise it wont work properly.
    var dynamicAssign: Int = 0

    init {
        dynamicAssign = marks + 10  // init block for primary constructor
    }

    constructor(age: Int, name: String?) : this(age, name, 0) { // if primary n secondary are present then Secondary constructor must call Primary one/other Secondary one.
    }

    constructor(age: Int, name: String?, other: String?) : this(age, name) {
        print((other ?: ""))
    }

    fun calculateMarks() {
        val progress: String = if (this.marks > 10) "good" else "bad"
        println("progress is $progress")
    }

    override fun toString(): String {
        return super.toString() + " marks is ${this.marks}  ; dynamicAssign is $dynamicAssign"
    }
}

class ThirdClass : FirstClass {
    constructor(age: Int, name: String?) : super(age, name) {  // calling super class without using Primary constructor.

    }
}

/*class Main {
}*/

class SimpleClass(var a: Int, var b: Int)   // add var , val parameters
// if u put data class  then difference is it will implement hashcode, tostring, COPY  as well ... THATS IT.

sealed class Shape {  // Sealed class is used when the object have one of the types from limited set, but cannot have any other type.
    class Circle(var radius: Float) : Shape()
    class Square(var length: Int) : Shape()
    class Rectangle(var length: Int, var breadth: Int) : Shape()
    //  object NotAShape : Shape()
}

fun eval(e: Shape) =
        when (e) {
            is Shape.Circle -> println("Circle area is ${3.14 * e.radius * e.radius}")
            is Shape.Square -> println("Square area is ${e.length * e.length}")
            is Shape.Rectangle -> println("Rectagle area is ${e.length * e.breadth}")
        //else -> "else case is not require as all case is covered above"
        //  Shape.NotAShape ->Double.NaN
        }

fun main(args: Array<String>) {
    val obj = SecondClass(20, null, 35)
    obj.calculateMarks()
    println(obj.toString())
    val simpleObj = SimpleClass(20, 30)
    print(simpleObj.a)

    var circle = Shape.Circle(5.0f)
    var square = Shape.Square(5)
    eval(circle)
    eval(square)
}