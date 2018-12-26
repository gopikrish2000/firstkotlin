package gopi.kotlintest.nextlevel

class Root {

    var rootFirstMember:String = "rootFirstMemeber"

    operator fun invoke(block: Root.() -> Unit){
        Root().block()
    }
    /*operator fun invoke(block: Head.() -> Unit): Head{
        val head = Head {

        }
        head.block()
        return head
    }*/

    fun head(block: Head.() -> Unit){
        Head().block()
    }

    fun body(block: Body.() -> Unit){
        Body().block()
    }

}

class Head {
    var headFirstVar = "333"
    /*operator fun invoke(block: Body.() -> Unit): Body{
        val body = Body()
        body.block()
        return body
    }*/

    fun addHeadMember(function: () -> Unit){

    }
}

class Body {
    var bodyFirstVar = "456564"
    fun addBodyChildMember(function: BodyChild.() -> Unit){
        BodyChild().function()
    }
}

class BodyChild {
    var bodyChildFirstVar = "iii"
    fun addBodyChildMember (function: () -> Unit){

    }
}

class KotlinDsl(var abc:String) {


}

fun main(args: Array<String>) {
    val rootObj = Root()
    rootObj {
        rootFirstMember = "wwww"
        head {
            headFirstVar = "2"
            addHeadMember {

            }
        }

        body {
            bodyFirstVar = "324423"
            addBodyChildMember {
                bodyChildFirstVar = "1222"
            }
        }
    }
    /*rootObj{
        execute {
            rootFirstMember = "er3"
        }
        *//*invoke {
            rootFirstMember = "wrw"
        }*//*
    }*/

    /*rootObj{
        Head{
            addHeadMember{
                print("inside nesting")
            }
        }
    }*/

    println(KotlinDsl("asdfsa").abc)

}