// Lambda expressions with receiver
class DrawShape {
    fun drawCircle() = println("Drawing a circle")
    fun drawSquare() = println("Drawing a square")
}

// Lambda expression with receiver definition
fun render(block: DrawShape.() -> Unit): DrawShape {
    val shape = DrawShape()
    // Use the lambda expression with receiver
    shape.block()
    return shape
}

fun main() {
    render {
        drawCircle()
        drawSquare()
    }
}