package gopi.kotlintest.initial.advanced

import jdk.nashorn.internal.objects.NativeString.substring
import java.awt.SystemColor.text
import java.time.Year
import java.util.*


class KotlinScopesManager {

    fun receiverLambdaFirst(lambda: KotlinReceiver.() -> Unit) {
        KotlinReceiver("first", 25).lambda()
    }


    data class KotlinReceiver(var name: String, var age:Int){
        var otherVar: String? = null
    }

    fun test() {

        // let , also -> it word
        // run , apply -> this
        var text: String? = "ghjghk"
        val len = text?.let {
//            println("get length of $it")
            "${it.length} $it"
        } ?: 0
        println("Length of $text is $len")


        val lenFirst = text?.run {  // run u can use this. without explict variables like it
//            println("get length of $it")
            "${length} $this"
        } ?: 0
        println("LengthFirst of $text is $lenFirst")

        val newText = text?.run { this.substring(0,3) }?.run { plus("ADDING_HERE") }  // wont change the original string, so have to assign new variable
        println("text of RUN is $newText")

        val currentDate = Calendar.getInstance().run {
            set(Calendar.YEAR, 2020)
            get(Calendar.YEAR)
        }
        println("currentDate is $currentDate")

        // run u can use this. without explict variables like it
        val lenSecond = text?.let { it.length }?.let { it.div(2f) }    // let returns updated type.


        val lenAlso = text?.run {
//            println("get length of $it")
            length
        }?.run { this.div(2f) }    // let returns updated type.

        val latestLen = text?.apply {
            //            println("get length of $it")
            text.plus("11111")
            text = "MyAssignedTexttt"
//            length
        }

        println("latestLen is $latestLen")
    }

    fun testNew() {
        var obj: KotlinReceiver = KotlinReceiver("nameMy", 22).apply { otherVar = "234242" }  // gives back original reference
        var objRun:Unit = KotlinReceiver("nameMy", 22).run { otherVar = "234242" }  // useful for nesting but not for object initialization.
        println("printing $obj Also ${obj.otherVar}")
//        println("printingRUN $objRun Also ${objRun.otherVar}")
    }


}

fun main(args: Array<String>) {
    val obj = KotlinScopesManager()
    obj.receiverLambdaFirst {
        //Toast.makeText(MainApplication.getAppContext(), "receiver", Toast.LENGTH_SHORT).show()
        System.out.println("gfhfhfhfgfhfhg $name" )
//        obj.test()
        obj.testNew()
    }
}