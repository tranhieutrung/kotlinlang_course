fun main() {
    println("Hello, world!")
    // Hello, world!

    val customers = 10
    println("There are $customers customers")
    println("There are ${customers + 1} customers")

    val num =  5
    //val can not reassigned
    // num += 5
    println("The number is $num")

    var num2 = 5
    num2 += 2
    println("The number is $num2")

    var str = "Hello"
    str += ", "
    println(str + "world!")

    val name = "Mary"
    val age = 20

    println("$name is $age years old")
}