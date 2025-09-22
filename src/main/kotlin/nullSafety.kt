//Check for null values﻿

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else if (maybeString != null && maybeString.length == 0) {
        return "Empty string"
    } else {
        return "Null string"
    }
}

// Use safe calls operator '?'

fun lengthString(maybeString: String?): Int? = maybeString?.length


// Exercise:
data class Employee (val name: String, var salary: Int)

fun employeeById(id: Int) = when(id) {
    1 -> Employee("Mary", 20)
    2 -> null
    3 -> Employee("John", 21)
    4 -> Employee("Ann", 23)
    else -> null
}

fun salaryById(id: Int) = employeeById(id)?.salary ?: 0

fun main() {
    // By default, null values aren't accepted
    var inferredNonNull = "The compiler assumes non-nullable"

    // Throws a compiler error
    // inferredNonNull = null
	
	// neverNull has String type
    var neverNull: String = "This can't be null!"

    // Throws a compiler error
    // neverNull = null

    // nullable has nullable String type by adding '?'
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    

    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {                 
        return notNull.length
    }

    println(strLength(neverNull))
    // Throws a compiler error
    // println(strLength(nullable))

    // Check for null values

    val nullString: String? = null
    println(describeString(nullString))
    println(describeString(null))
    println(describeString(""))
    println(describeString("Hello, world!"))

    // Use safe calls
    println(lengthString(nullString))
    println(lengthString(""))
    println(lengthString("Hello, world!"))

    println(nullString?.uppercase())
    val newString: String? = "Hello"
    println(newString?.uppercase())

    // Use Elvis operator
    // Write on the left-hand side of the Elvis operator what should be checked for a null value. Write on the right-hand side of the Elvis operator what should be returned if a null value is detected.
    println(nullString?.length ?: 0)

    // Exercise:
    println((1..5).sumOf { id -> salaryById(id) })

}