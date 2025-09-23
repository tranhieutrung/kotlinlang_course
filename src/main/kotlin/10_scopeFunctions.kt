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

val client = Client().apply { // global scope
    token = "asdf"
    connect()
    authenticate()
}

// 3. Run
// Similar to apply, you can use the run scope function to initialize an object, but it's better to use run to initialize an object at a specific moment in your code and immediately compute a result.
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
    client.getData()

    // 3. Run

}
