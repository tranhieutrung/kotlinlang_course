class Contact(val id: Int, var email: String) {
    // Member functions
    fun printId() {
        println(id)
    }
}

// Constructors
class InitOrderDemo(name: String) { //The class header can't contain any runnable code
    val firstProperty = "First property: $name".also(::println)

    //  use initializer blocks to run some code during object creation
    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// Data classes have the same functionality as classes, but they come automatically with additional member functions
data class User(val name: String, val id: Int)

fun main() {
    // constructor
    val contact = Contact(1, "John@mail.com")

    // Access properties
    println("Their email address is: ${contact.email}")
    println(contact.email)
    contact.email = "jane@gmail.com"
    println(contact.email)

    // Access member functions
    contact.printId()

    val order = InitOrderDemo("John")

    val user = User("Alex", 1)

    // Automatically uses toString() function so that output is easy to read
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // Compares user to other users
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    // Copy instance
    println(user.copy())
    // Creates a copy of user with name: "Max"
    println(user.copy("Max"))
    // Creates a copy of user with id: 3
    println(user.copy(id = 3))
}