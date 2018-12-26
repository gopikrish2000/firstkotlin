package gopi.kotlintest.initial.advanced

class KotlinDelegates {

    var firstName: String = "firstName"
    var lastName:String = "lastName"

    var myComplexBackingField: String = "sfd"
    var myComplexVariable : String by GopiComplexVariableDelegate()

    var name:String
    get() = firstName.plus(" ") +  lastName
    set(value) {
        val split = value.split(" ".toRegex())
        firstName = split[0]
        lastName = split[1]
    }

    var backingString: String = "init"
        get() {
            return field+"qqq"   // field is used to avoid recursive same variable calls to avoid StackOverflowException
        }
        set(value) {
            if (value.length > 5) field = value
        }


    fun testOfLet() {
        var name: String? = "adf"
        val abc = name?.run { this.length }

    }
}

fun main(args: Array<String>) {
    val obj = KotlinDelegates()
    obj.backingString = "sfs"
    println(" value of backingString when set to sfs is ${obj.backingString}")

    obj.backingString = "sfswerwrwrwrw"
    println(" value of backingString when set to sfswerwrwrwrw is ${obj.backingString}")

    println(" fullName is ${obj.name}")
    obj.name = "Complex Names"
    println(" fullName is ${obj.name} ; with other field values as ${obj.firstName} :::  ${obj.lastName}")

    println(" myComplexVariable is ${obj.myComplexVariable}")

    obj.myComplexVariable = " settingOtherComplexValue"
    println(" myComplexVariable is ${obj.myComplexBackingField}")


}