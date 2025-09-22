/*
Integers: Byte, Short, Int, Long
Unsigned integers: UByte, UShort, UInt, ULong
Floating-point numbers: Float, Double
Booleans: Boolean
Characters: Char
Strings: String
 */

fun main() {
    // Variable declared without initialization
    val d: Int
    // Variable initialized
    d = 3
    println(d)

    // Variable explicitly typed and initialized
    var num: UInt = 100u
    num *= 2u  //not able to do num *= 2 because 2 is Int, not UInt
    println(num)

    val isEnabled: Boolean = true
    println(isEnabled)

    val e: String = "hello"

    // Variables can be read because they have been initialized
    println(e)
}