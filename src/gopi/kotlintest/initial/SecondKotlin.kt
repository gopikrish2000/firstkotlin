package gopi.kotlintest.initial

fun nullAbility() {
    val str1: String? = "Hello"     // variable is declared as nullable
    var len = if (str1 != null) str1.length else -1  // if can directly return a value.


    val obj: Any = "The variable obj is automatically cast to a String in this scope"  // Any is like Object class
    if (obj is String) {  // smart cast
        println("String length is ${obj.length}")  // No Explicit Casting needed.
    }
    if (obj !is Int) {  // is not operator.
        println(" is not operator check ")
    }
    val string: String? = null
    println("conditional length is " + (string?.length ?: -3))  // string?.length returns null not 0  ; to get -3 do string?.length ?: -3  [ using elvis operator ] for default
    if (string != null) {  // smart cast
        println(string.length)
    }

    val abc:Int = string?.length!!;   // either we have to make abc ?  or string?.length!! to make sure it is non null.

    val location: Any = "Kotlin"
    val safeString: String? = location as? String  // safe cast
    val safeInt: Int? = location as? Int
    println(safeString)
    println(safeInt)  //null

    var str: String? = null
    var len1: Int = str?.length ?: -1  // returns -1 only when left side is null.

    println("Length of str is ${len1}")

   /* val parent = node.getParent() ?: return null
val name = node.getName() ?: throw IllegalArgumentException("name expected")  */
}

fun check(textOne: String?, textTwo: String?): String? {
    val textOne = textOne ?: return null
    val textTwo = textTwo ?: IllegalArgumentException("text exception")
    val textThree = textOne ?: ""
    return textThree
}

fun sampleABC() {
    val string : String?
    string = null
    val length: Int = string?.length ?: 0

    print("string length is ${string?.length}")
}

fun main(args: Array<String>) {
//    nullAbility()
    sampleABC()
}