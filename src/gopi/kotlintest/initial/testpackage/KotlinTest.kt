package gopi.kotlintest.initial.testpackage

class KotlinTest {
    var mySet: MutableSet<String> = HashSet()
    get() {
        println("get called for mySet current value is $field")
        return field
    }
    set(value) {
        field = value
        println("set called for mySet with value $value")
    }


    fun test() {
        var string: String? = "sdfsf"
        var counter: Int? = 2
        for (i in 0..(counter?.minus(1)?:-10)){
            println("i is $i")
        }
    }

    fun testContinue(){
        var items = mutableListOf("abc", null, "def")
       /* for (item in items){

        }*/
        for (i in 0 until items.size){
            val value = items[i] ?: continue
            println("value is $value")
        }
    }
}

fun main(args: Array<String>) {
    val obj = KotlinTest()
    obj.test()


    /*obj.mySet.add("first")
    obj.mySet.add("second")
    obj.mySet.removeIf{it == "second"}

    println(obj.mySet)*/
    obj.testContinue()

}