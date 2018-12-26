package gopi.kotlintest.initial


fun first(a: String = "empty"): String {
    return a.plus("ADDED")
}

fun sec(a: String) {
    a.forEach { alpha ->
        {
            print(alpha);
        }
    }
}

val sumLambda: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
val sumLambda1: (Int, Int) -> Int = { a, b -> a + b }  // no need to declare type
val voidLambda: () -> Int = { 10 };
val voidLambdaOther: () -> Unit = { print("voidLambdaOther  ***") }

fun doOperation(fir: Int, sec: Int, function: (Int, Int) -> Int): Int {
    return function(fir, sec);
}

inline fun inlineFirst(/*crossinline*/ firstF: () -> Unit, secondF: () -> Unit, thirdF: (Int) -> Int) {  // crossinline will avoid making lambdas return.
    firstF()
    print("inline Func Code")
    secondF()
    print("third value is " + thirdF(3))
}

fun tempInlineTester(firstF: () -> Unit) {
    firstF()
}

fun main(args: Array<String>) {
    println(first())
    println(first("sending"))

    val name1 = """
        This is
        a


        asdf
        asf
        asf
        aas
        df
        f
        a
        as
        fs

        df
        as
    """.trimIndent()

    println(name1)

    val b: String? = null;
    b?.let { sec(it) };

    val result1 = doOperation(3, 4) { a, b ->
        print("inside ");

        val r: Int = a * a * b
        a + b
//        r
    }  // no need to write return statement by default it will be returned
    println("sum result is $result1");
    val result2 = doOperation(3, 4) { a: Int, b: Int -> a * b }
    /*println("mul result is $result2");
    val result3 = doOperation(3, 4) { a: Int, b: Int -> a - b }
    println("sub result is $result3");
    println("void lambda" + voidLambda())
    voidLambdaOther() */

    inlineFirst({ print("InlineFirst"); return }, { print("InlineSecond") }, { a -> a + 2 })  // u can return from the inline function itself unless parameter name specified with crossinline keyword
    tempInlineTester({ println("TEMP Non INLINE") })
    val name = arrayOf<String>("Ajay", "Prakesh", "Michel", "John", "Sumit")
    for (element in name) {
        println(element)
    }
    val a = 10
    val myString = """value $a
        |is greater than value
    """.trimMargin()   // raw string without escaping can write what ever u want

    val tryString = try {     // try can return a value too
        println("${myString.trimMargin()}")
        "abcd"
    } catch (e: Exception) {
        ""
    }


}
