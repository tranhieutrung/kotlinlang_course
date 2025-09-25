import kotlin.random.Random

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

// Primary constructor
//The primary constructor is declared in the class header, and it goes after the class name and optional type parameters
class Person1 constructor(firstName: String) { /*...*/ }
//If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted
class Person2(firstName: String) { /*...*/ }

//Secondary constructors
class Person3(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    //secondary constructors are prefixed with constructor inside class's body
    constructor(owner: Person3) {
        owner.pets.add(this) // adds this pet to the list of its owner's pets
    }
}

// Delegation to another constructor of the same class is done using the "this" keyword
class Person4(val name: String) {
    val children: MutableList<Person4> = mutableListOf()
    constructor(name: String, parent: Person4) : this(name) {
        parent.children.add(this)
    }
}

/*Ex1:
Define a data class Employee with two properties: one for a name, and another for a salary.
Make sure that the property for salary is mutable, otherwise you won't get a salary boost at the end of the year!
The main function demonstrates how you can use this data class.
*/

//use a Data class to automatically get additional member functions
data class Employee(val name: String, var salary: Int) {}

/* Ex2:
Declare the additional data classes that are needed for the Ex2 code to compile.
 */
data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)

data class Name (val  firstName: String, val lastName: String)

data class Address (val  street: String, val city : City)

data class City (val city:  String, val country  : String)

/*
Ex3
To test your code, you need a generator that can create random employees.
Define a RandomEmployeeGenerator class with a fixed list of potential names (inside the class body).
Configure the class with a minimum and maximum salary (inside the class header).
In the class body, define the generateEmployee() function.
Once again, the main function demonstrates how you can use this class.
*/
class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    val nameList = listOf("Saku", "Shahnaj",  "Kim",  "Huong", "John", "David")
    fun generateEmployee() = Employee(nameList.random(), Random.nextInt(from = minSalary, until = maxSalary))
}


// Abstract classes
// Abstract classes can be inherited by default.
// The purpose of abstract classes is to provide members that other classes inherit or implement
// We can't create instances from them.
// Within the child class, you define the behavior of the parent's properties and functions with the override keyword
abstract class Animal (val type: String) {
    abstract fun makeSound()
}

class Dog: Animal("Dog") {
    override fun makeSound() {
        println("Woof woof!")
    }
    fun fetch() = println("Dog is fetching the ball!")
}

class Cat: Animal("Cat") {
    override fun makeSound() {
        println("Meoo meoo!")
    }
}

// Abstract ex:
/*
Imagine you're working on a smart home system.
A smart home typically has different types of devices that all have some basic features but also unique behaviors.
Complete the abstract class called SmartDevice so that the child class SmartLight can compile successfully.
Then, create another child class called SmartThermostat that inherits from the SmartDevice class
and implements turnOn() and turnOff() functions that return print statements (heating or turned off).
Finally, add another function called adjustTemperature() that accepts a temperature measurement as an input
and prints: $name thermostat set to $temperature°C.
*/
abstract class SmartDevice(val name: String) {
    abstract fun turnOn()
    abstract fun turnOff()
}

class SmartLight(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name is now ON.")
    }

    override fun turnOff() {
        println("$name is now OFF.")
    }

    fun adjustBrightness(level: Int) {
        println("Adjusting $name brightness to $level%.")
    }
}

class SmartThermostat(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name is now heating.")
    }

    override fun turnOff() {
        println("$name is now off.")
    }

    fun adjustTemperature(temperature: Int) {
        println("Set $name to $temperature°C")
    }
}

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

    // Secondary constructors
    val alice = Person3()
    val dog = Pet(alice)
    val cat = Pet(alice)

    // class Pet does not have any property, so the list of pets includes only references
    println("Alice's pets: ${alice.pets}")

    // Another example of secondary constructors
    val parent = Person4("Alice")
    val child = Person4("Bob", parent)
    println(parent.name)
    println(parent.children.map { it.name })

    //Ex1:
    println("Exercise 1:")
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)

    //Ex2:
    println("Exercise 2:")
    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )
    println(person)

    //Ex3:
    println("Exercise 3:")
    val empGen = RandomEmployeeGenerator(10, 30)
    println("1st print: ${empGen.generateEmployee()}")
    println("2nd print: ${empGen.generateEmployee()}")
    println("3rd print: ${empGen.generateEmployee()}")
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println("Last print: ${empGen.generateEmployee()}")

    // Abstract classes:
    val dog1: Animal = Dog()
    dog1.makeSound()
    // dog1.fetch() // dog1 is an Animal that doesn't have the fetch function
    val dog2: Dog = Dog()
    dog2.makeSound()
    dog2.fetch()
    val cat2: Animal = Cat()
    cat2.makeSound()

    // abstract ex:
    val livingRoomLight = SmartLight("Living Room Light")
    val bedroomThermostat = SmartThermostat("Bedroom Thermostat")

    livingRoomLight.turnOn()
    livingRoomLight.adjustBrightness(10)
    livingRoomLight.turnOff()

    bedroomThermostat.turnOn()
    bedroomThermostat.adjustTemperature(5)
    bedroomThermostat.turnOff()
}