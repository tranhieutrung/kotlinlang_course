import kotlin.random.Random

fun main() {
    // Conditional expressions
    // If conditions
    val d: Int
    val check = true

    if (check) {
        d = 1
    } else {
        d = 2
    }
    println(d)

    val a = 1
    val b = 2
    println(if (a > b) a else b)

    //When
    // when as a statement
    val obj = "Hello"
    when (obj) {
        "1" -> println("One")
        "Hello" -> println("Greeting")
        else -> println("Not found")
    }
    //when as an expression
    val result = when (obj) {
        "1" -> "One"
        "Hello" -> "Greeting"
        else -> "Not found"
    }
    println(result)

    // when without a subject
    val trafficLight = "Red"
    val trafficAction = when {
        trafficLight == "Red" -> "Stop"
        trafficLight == "Green" -> "Go"
        trafficLight == "Yellow" -> "Slow down"
        else -> "Malfunction"
    }
    println(trafficAction)

    // Exercise 1: Create a simple game where you win if throwing two dice results in the same number. Use if to print You win :) if the dice match or You lose :( otherwise.
    // Need to import random library to use Random.nextInt()

    val dice1 = Random.nextInt(6)
    val dice2 = Random.nextInt(6)
    println(if (dice1 == dice2) "You win" else "You lose")

    // Exercise 2: Using a when expression to print the corresponding actions
    val button = "A"
    val res = when (button) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }
    println(res)

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )

    // Ranges
    // 1..4 : 1,2,3,4
    // 1..<4 : 1,2,3
    // 4 downto 1: 4,3,2,1
    // 1..5 step 2 : 1,3,5
    // 'a'..'d' : 'a','b','c','d'
    // 'z' downTo 's' step 2 : 'z', 'x', 'v', 't'

    // Loops
    // For loop
    for (number in 1..10) {
        print(number)
    }
    println()
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it is a $cake cake")
    }

    //While loop
    var cakeEaten = 0
    while (cakeEaten < 3) {
        println("Eat a cake")
        cakeEaten++
    }

    var cakeBaked = 0
    do {
        println("Bake a cake")
        cakeBaked++
    } while (cakeBaked < cakeEaten)

    //Exercise 3: count pizza slices until there's a whole pizza with 8 slices
    var pizzaSlices = 1
    while (pizzaSlices < 8) {
        if (pizzaSlices == 1) {
            println("There's only $pizzaSlices slice of pizza :(")
        } else {
            println("There are only $pizzaSlices slices of pizza :(")
        }
        pizzaSlices++
    }
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    pizzaSlices = 1
    do {
        if (pizzaSlices == 1) {
            println("There's only $pizzaSlices slice of pizza :(")
        } else {
            println("There are only $pizzaSlices slices of pizza :(")
        }
        pizzaSlices++
    } while (pizzaSlices < 8)
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    //Exercise 4: Write a program that simulates the Fizz buzz game
    for (num in 1..100) {
        println(
            when {
                num % 15 == 0 -> "fizzbuzz"
                num % 3 == 0 -> "fizz"
                num % 5 == 0 -> "buzz"
                else -> "$num"
            }
        )
    }

    //Exercise 5: Use for and if to print only the words (from a list) that start with the letter l.
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (word in words) {
        if (word.startsWith("l")) { //word[0] == 'l'
            println(word)
        }
    }
}