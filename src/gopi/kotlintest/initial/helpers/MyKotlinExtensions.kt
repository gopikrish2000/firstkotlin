package gopi.kotlintest.initial.helpers

fun String.toSnakeCase(): String {
    var text = ""
    var isFirst = true
    this.forEach {
        if (it.isUpperCase()) {
            if (isFirst) isFirst = false
            else text += "_"
            text += it.toLowerCase()
        } else {
            text += it
        }
    }
    return text
}

inline fun <reified T> Any.ifNullReturn(input: T?): () -> Unit{
//    input ?: {return}
    if(input == null){
        return {
//            return Unit
        }
    }
    else {
        return { }
    }
}


/*
inline fun <T> Any.ifNullReturn(input: () -> Unit) {
//    input ?: {return}
    input()
}*/
