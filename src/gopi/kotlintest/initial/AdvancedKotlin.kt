package gopi.kotlintest.initial

import gopi.kotlintest.javacode.KotlinJavaTest

val sampleConstant:Int = 4444

fun String.isNullOrEmptyGopi(): Boolean {   // Extension is ClassName.methodName  to add functionality to class
    if (this != "aa") println("sdf")
    return (this.trim().length) > 0
}

fun String?.isNullOrEmptyGopiNullable(): Boolean {   // Extension supporting nullable types.
    if (this == null) {  //can check for nullability n do something else.
        println("This object is null.")
    }
    return (this?.trim()?.length ?: 0) > 0
}

fun String.Companion.stringStaticMethod(a: String?) {  // to add a Static extension.
    print(a + " static method called ")
}

fun sample() {
    val a: String? = "sdf"
    if (!a!!.isNullOrEmptyGopi()) println("a is null or empty") else println("a is non null")
    if (!a.isNullOrEmptyGopiNullable()) println("a is null or empty") else println("a is non null")
}

class GenericClass<T>(var name: String? = null, var value: T) {
    companion object {  // to declare as static method nest it in companion object.
        fun firstStaticFunc() {
            println("This is first static function")
        }

        fun secondStaticFunc() {
            println("This is second static function")
        }
    }

    fun <T> doCalculation(value: T) {
        if (value is String) {
            println("T is string with value $value")
        } else {
            println("T is not string.")
        }
    }
}

fun <T> ArrayList<T>.printValues() {
    for (element in this) {
        print(element)
    }
}

data class NewClass(var name: String? = "gopi", var age: Int)



fun main(args: Array<String>) {
    sample()
    String.stringStaticMethod("werwerwr")
    GenericClass.firstStaticFunc()
    val genericObj = GenericClass<Int>(value = 44)
    genericObj.doCalculation("sfd")

    val floatList: ArrayList<Float> = arrayListOf<Float>(10.5f,5.0f,25.5f)
    floatList.printValues()
    val intArraySample = intArrayOf(1, 2, 3)
    KotlinJavaTest().display("abc", *intArraySample)  // use spread operator for var args in java.

    val newClassObj = NewClass(age = 22)
    println(newClassObj.toString())
    newClassObj.copy().age = 25
}