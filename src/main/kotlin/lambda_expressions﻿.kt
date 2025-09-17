fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hours" -> {value -> value * 3600}
    "minutes" -> {value -> value * 60}
    "seconds" -> {value -> value}
    else -> {value -> value}
}

fun main() {
    val upperCaseString = { text: String -> text.uppercase() }
    val upperCaseStringWithFunctionType: (String) -> String = { text -> text.uppercase() }

    println(upperCaseString("hello"))
    println(upperCaseStringWithFunctionType("world"))

    //If declare a lambda without parameters, no need to use ->
    val printLog = { println("lambda without parameters") }
    printLog()

    println({ text: String -> text.uppercase() }("Invoke separately"))

    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter ({x -> x > 0})
    val isNegative = { x: Int -> x < 0 }
    val negatives = numbers.filter (isNegative)

    println(positives)
    println(negatives)

    val doubled = numbers.map { x -> x * 2 }
    val isTripled = { x: Int -> x * 3 }
    val tripled = numbers.map(isTripled)
    println(doubled)
    println(tripled)

    val timeInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minutes")
    val totalTimeInSeconds = timeInMinutes.map (min2sec).sum()
    println("Total time is $totalTimeInSeconds seconds")

    // Trailing lambdas
    // The operation sums the initial value with every item in the list cumulatively.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item }))

    // Alternatively, in the form of a trailing lambda
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })
}