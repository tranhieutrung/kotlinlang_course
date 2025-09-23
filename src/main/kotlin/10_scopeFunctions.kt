// Scope functions
// The most commonly referred to scopes are the global scope and the local scope
// Depending on the scope function, you can access the object either by referencing it via the keyword this or using it as an argument via the keyword it.
// Kotlin has five scope functions in total: let, apply, run, also, and with.

// 1. Let
// Use the let scope function to perform null checks and later perform further actions with the returned object.

fun sendNotification(recipientAddress: String): String {
    println("Yo $recipientAddress!")
    return "Notification sent!"
}

fun getNextAddress(): String {
    return "sebastian@jetbrains.com"
}

// 2. Apply
// Use the apply scope function to initialize objects, like a class instance, at the time of creation rather than later on in your code. This approach makes your code easier to read and manage.

class Client() {
    var token: String? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData(): String = "Mock data"
}
// Normally, we create client as an instance of the Client class before initializing its token and calling member functions in the main function:
//val client = Client()
//
//fun main() {
//    client.token = "asdf"
//    client.connect()
//    // connected!
//    client.authenticate()
//    // authenticated!
//    client.getData()
//}

// instead of that, we use apply scope function:
// client1 is a top-level (global) variable. It is initialized before main() runs.
// During initialization, the apply block executes and calls connect() and authenticate().
val client1 = Client().apply {
    token = "asdf"
    connect()
    authenticate()
}

// 3. Run
// Similar to apply, you can use the run scope function to initialize an object, but it's better to use run to initialize an object at a specific moment in your code and immediately compute a result.

// Instead of configuring all member functions at initialization with apply,
// here we use run in main to call functions and return the result.
val client2: Client = Client().apply {
    token = "asdf"
}

// 4. Also
// Use the also scope function to complete an additional action with an object and then return the object to continue using it in your code, like writing a log.

// We can use the also functions to add some logging between the function calls of this code:
//fun main() {
//    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
//    val reversedLongUppercaseMedals: List<String> =
//        medals
//            .map { it.uppercase() }
//            .filter { it.length > 4 }
//            .reversed()
//    println(reversedLongUppercaseMedals)
//    // [BRONZE, SILVER]
//}

// 5. With
// Unlike the other scope functions, with is not an extension function, so the syntax is different. You pass the receiver object to with as an argument.

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}

// Exercise 1:
data class ProductInfo(val priceInDollars: Double?)

class Product {
    fun getProductInfo(): ProductInfo? {
        return ProductInfo(100.0)
    }
}

// Rewrite this function
//fun Product.getPriceInEuros(): Double? {
//    val info = getProductInfo()
//    if (info == null) return null
//    val price = info.priceInDollars
//    if (price == null) return null
//    return convertToEuros(price)
//}
fun Product.getPriceInEuros() = getProductInfo()?.priceInDollars?.let {
    convertToEuros(it)
}

fun convertToEuros(dollars: Double): Double {
    return dollars * 0.85
}

// Exercise 2
data class User2(val id: Int, var email: String)

// Use the apply scope function to update the email address and then the also scope function to print a log message
fun updateEmail(user: User2, newEmail: String): User2 = user.apply {
    this.email = newEmail
}. also { println("Updating email for user with ID: ${it.id}.") }

fun main() {
    // 1. Let
    val address: String? = getNextAddress()
    // 'cause the input of sendNotification function is a non-null string, need to check if the address is not null
    // a. normal check:
    //val confirm = if(address != null) {
        //sendNotification(address)
    //} else { null }

    // b. OR use let scope function:
    val confirm = address?.let {
        // Refers to the address variable via it, using the temporary scope
        sendNotification(it)
    }

    // 2. Apply
    // only call getData function
    client1.getData()

    // 3. Run
    val result: String = client2.run {
        connect()
        authenticate()
        getData()
    }

    // 4. Also
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .also { println(it) } //use also to print the intermediate result of map without breaking the chain
            .filter { it.length > 4 }
            .also { println(it) } //use also again to print the intermediate result of filter before reversed
            .reversed()
    println(reversedLongUppercaseMedals)

    // 5. With
    val mainMonitorPrimaryBufferBackedCanvas = Canvas()

    mainMonitorPrimaryBufferBackedCanvas.text(10, 10, "Foo")
    mainMonitorPrimaryBufferBackedCanvas.rect(20, 30, 100, 50)
    mainMonitorPrimaryBufferBackedCanvas.circ(40, 60, 25)
    mainMonitorPrimaryBufferBackedCanvas.text(15, 45, "Hello")
    mainMonitorPrimaryBufferBackedCanvas.rect(70, 80, 150, 100)
    mainMonitorPrimaryBufferBackedCanvas.circ(90, 110, 40)
    mainMonitorPrimaryBufferBackedCanvas.text(35, 55, "World")
    mainMonitorPrimaryBufferBackedCanvas.rect(120, 140, 200, 75)
    mainMonitorPrimaryBufferBackedCanvas.circ(160, 180, 55)
    mainMonitorPrimaryBufferBackedCanvas.text(50, 70, "Kotlin")

    // instead of that, we can use with function
    val mainMonitorPrimaryBufferBackedCanvas2 = Canvas()
    with(mainMonitorPrimaryBufferBackedCanvas2) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }

    // Exercise 1
    val product = Product()
    val priceInEuros = product.getPriceInEuros()

    if (priceInEuros != null) {
       println("Price in Euros: €$priceInEuros")
    } else {
        println("Price information is not available.")
    }

    // Exercise 2
    val user = User2(1, "old_email@example.com")
    val updatedUser = updateEmail(user, "new_email@example.com")
    // Updating email for user with ID: 1

    println("Updated User: $updatedUser")
    // Updated User: User(id=1, email=new_email@example.com)
}

/*
Scope Functions Cheatsheet:

Function | Access to x via | Return value   | Use case
---------|-----------------|----------------|----------------------------------------------
let      | it              | Lambda result  | Perform null checks and later actions
apply    | this            | x              | Initialize objects at the time of creation
run      | this            | Lambda result  | Initialize objects at creation AND compute result
also     | it              | x              | Do additional actions (side effects) before returning
with     | this            | Lambda result  | Call multiple functions on an object
*/
