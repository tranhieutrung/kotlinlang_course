// Lambda expressions with receiver
class DrawShape {
    fun drawCircle() = println("Drawing a circle")
    fun drawSquare() = println("Drawing a square")
}

// Lambda expression with receiver definition
// { receiverType.() -> returnType }
fun render(draw: DrawShape.() -> Unit): DrawShape {
    val shape = DrawShape()
    // Use the lambda expression with receiver
    shape.draw()
    return shape
}


//Example 2:
class MenuItem(val name: String)

class Menu(val name: String) {
    val items = mutableListOf<MenuItem>()

    fun item(name: String) {
        items.add(MenuItem(name))
    }
}

fun menu(name: String, init: Menu.() -> Unit): Menu {
    val menu = Menu(name)
    menu.init()
    return menu
}

fun printMenu(menu: Menu) {
    println("Menu: ${menu.name}")
    menu.items.forEach { println("  Item: ${it.name}") }
}

fun main() {
    render {
        drawCircle()
        drawSquare()
    }

    val mainMenu = menu("Main menu") {
        item("Home")
        item("Settings")
        item("Exit")
    }
    printMenu(mainMenu)
}