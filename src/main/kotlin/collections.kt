/*
Lists: Ordered collections of items
Sets: Unique unordered collections of items
Maps: Sets of key-value pairs where keys are unique and map to only one value
 */

fun main() {
    // Lists
    // Read-only list
    val readOnlyShapes = listOf("triangle", "square", "circle", "triangle")
    println(readOnlyShapes)
    println("The first item in the list is: ${readOnlyShapes[0]}")
    println("The first item in the list is: ${readOnlyShapes.first()}")
    println("The last item in the list is: ${readOnlyShapes.last()}")

    println("This list has ${readOnlyShapes.count()} items")
    println("circle" in readOnlyShapes)

    // Mutable list with explicit type declaration
    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
    println(shapes)
    // Add "pentagon" to the list
    shapes.add("pentagon")
    println(shapes)
    shapes.remove("pentagon")
    println(shapes)

    //To prevent unwanted modifications, we can create a read-only view of a mutable list by assigning it to a List
    val shapesLocked: List<String> = shapes
    println(shapesLocked)


    //Sets
    // Read-only set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit)

    // Mutable set with explicit type declaration
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    println(fruit)

    // To prevent unwanted modifications, we can create a read-only view of a mutable set by assigning it to a Set:
    val fruitLocked: Set<String> = fruit
    println(fruitLocked)

    // As sets are unordered, we can't access an item at a particular index
    println("This set has ${readOnlyFruit.count()} items")
    println("banana" in readOnlyFruit)
    fruit.add("dragonfruit")    // Add "dragonfruit" to the set
    println(fruit)
    fruit.remove("dragonfruit") // Remove "dragonfruit" from the set
    println(fruit)

    //Maps
    // Every key in a map must be unique so that Kotlin can understand which value we want to get.
    // We can have duplicate values in a map.

    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)

    // Mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(juiceMenu)

    // To prevent unwanted modifications, we can create a read-only view of a mutable map by assigning it to a Map:
    val juiceMenuLocked: Map<String, Int> = juiceMenu

    // To access a value in a map
    println("The value of apple juice is: ${readOnlyJuiceMenu["apple"]}")

    // If we try to access a key-value pair with a key that doesn't exist in a map, we see a null value:
    println("The value of pineapple juice is: ${readOnlyJuiceMenu["pineapple"]}")

    // Use the indexed access operator [] to add items to a mutable map
    juiceMenu["coconut"] = 150 // Add key "coconut" with value 150 to the map
    println(juiceMenu)

    juiceMenu.remove("orange")    // Remove key "orange" from the map
    println(juiceMenu)

    // To get the number of items in a map
    println("This map has ${readOnlyJuiceMenu.count()} key-value pairs")

    //To check if a specific key is already included in a map
    println(readOnlyJuiceMenu.containsKey("kiwi"))

    // To obtain a collection of the keys or values of a map
    println(readOnlyJuiceMenu.keys)
    println(readOnlyJuiceMenu.values)

    // To check that a key or value is in a map
    println("orange" in readOnlyJuiceMenu.keys)
    // Alternatively, we don't need to use the keys property
    println("orange" in readOnlyJuiceMenu)
    println(200 in readOnlyJuiceMenu.values)


    //Exercises 1: print total numbers of 2 lists.
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    println(greenNumbers.count() + redNumbers.count())

    //Exercises 2: check whether the requested protocol is supported or not
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "ftp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")

    //Exercises 3: Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number.
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 4
    println("$n is spelt as '${number2word[n]}'")

}