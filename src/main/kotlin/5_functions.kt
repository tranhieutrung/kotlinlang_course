import kotlin.math.PI //exercise 1

fun hello() {
    return println("Hello, world!")
}

fun sum(x: Int, y: Int): Int {
    return  x + y
}

fun multiply(x: Int, y: Int) = x * y //single-expression function

fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
    // `return Unit` or `return` is optional
}

//function with default para(s)
fun printMessageWithDefaultPrefix(message: String, prefix: String = "Default") {
    println("[$prefix] $message")
}

// Early return
val registeredUsername = mutableListOf("john", "david")
val registeredEmail = mutableListOf("john@mail.com", "david@mail.com")
fun registerUser(username: String, email: String): String {
    if (username in registeredUsername) {
        return "Username already registered: $username"
    }
    if (email in registeredEmail) {
        return "Email already registered: $email"
    }
    registeredUsername.add(username)
    registeredEmail.add(email)
    return "User registered successfully: $username"
}

//Ex1: Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle.
fun circleArea(radius: Int): Double {
    return PI * radius * radius
}

// Ex2: Rewrite the circleArea function from the previous exercise as a single-expression function.
fun circleArea2(radius: Int): Double = PI * radius * radius

//Ex3: default para function
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) = hours * 3600 + minutes * 60 + seconds

fun main() {
    hello()
    println(sum(1, 2))
    //uses named args with swapped parameter order
    printMessageWithPrefix(prefix = "buzz", message = "Hello, world!")

    printMessageWithDefaultPrefix("Hello, world!","log")
    printMessageWithDefaultPrefix("Hello, world!")
    printMessageWithPrefix(prefix = "magazine", message = "Hello, world!")

    println(registerUser("john", "john@gmail.com"))
    println(registerUser("david2", "david@mail.com"))
    println(registerUser("david3", "david3@mail"))

    //Ex1&2
    println(circleArea(3))
    println(circleArea2(3))

    //Ex3
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(2))
    println(intervalInSeconds(minutes = 1))
    println(intervalInSeconds(hours = 1, seconds = 1))
}