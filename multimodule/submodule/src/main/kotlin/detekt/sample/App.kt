package detekt.sample

import java.util.Date

fun main() {
    println("Hello detekt multi module sample!")
}

private enum class E {
    E1,
    E2
}

private fun test() {
    //Deprecation
    Date(2019, 5, 5)
    //MissingWhenCase
    val e: E? = null
    when(e) {
        E.E1 -> Unit
    }
    //HasPlatformType
    val s = System.getProperty("key")
    //UnsafeCallOnNullableType
    val someEnum: E? = E.values().firstOrNull()
    println(someEnum!!.name)
    //UnsafeCast
    val a: Any = E.values().first().ordinal
    println(a as String)
    println(a as E)
    //RedundantElseInWhen
    when (e) {
        E.E1 -> Unit
        E.E2 -> Unit
        null -> Unit
        else -> Unit
    }
}
