// Extension functions

fun String.hello(): String = "Hello, $this!"

//Extension-oriented design

data class HttpResponse(val body: String)

class HttpClient {
    fun request(method: String, url: String, headers: Map<String, String>): HttpResponse {
        println("Requesting $method to $url with headers: $headers")
        return HttpResponse("Response from $url")
    }
}

fun HttpClient.get(url: String): HttpResponse = request("GET", url, emptyMap())

// Exercise 1
// Write an extension function called isPositive that takes an integer and checks whether it is positive.

fun Int.isPositive(): Boolean = this > 0

// Exercise 2
// Write an extension function called toLowercaseString that takes a string and returns a lowercase version.

fun String.toLowercaseString(): String = this.lowercase()

fun main() {

    println("Trung".hello())

    val client = HttpClient()

    // Making a GET request using request() directly
    val getResponseWithMember = client.request("GET", "https://example.com", emptyMap())

    // Making a GET request using the get() extension function
    val getResponseWithExtension = client.get("https://example.com")

    // Exercise 1
    println(1.isPositive())

    //Excercise 2
    println("Hello World!".toLowercaseString())
}
