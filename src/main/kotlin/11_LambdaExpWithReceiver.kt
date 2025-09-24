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

// Lambda expressions with receiver are helpful when you want to create a domain-specific language (DSL)
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


//Exercise 1:
//  Having a fetchData() function that accepts a lambda expression with receiver.
//  Update the lambda expression to use the append() function so that the output is: Data received - Processed.
fun fetchData(callback: StringBuilder.() -> Unit) {
    val builder = StringBuilder("Data received")
    builder.callback()
}

//Ex2:
// Write some code that triggers the onEvent() member function of the Button class to trigger a double-click event.
// Your code should print "Double click!".

class Button {
    fun onEvent(action: ButtonEvent.() -> Unit) {
        // Simulate a double-click event (not a right-click)
        val event = ButtonEvent(isRightClick = false, amount = 2, position = Position(100, 200))
        event.action() // Trigger the event callback
    }
}

data class ButtonEvent(
    val isRightClick: Boolean,
    val amount: Int,
    val position: Position
)

data class Position(
    val x: Int,
    val y: Int
)

// Ex3:
// Write a function that creates a copy of a list of integers where every element is incremented by 1.
// Use the provided function skeleton that extends List<Int> with an incremented function.
fun List<Int>.incremented(): List<Int> {
    val originalList = this
    // Or: return this.map{it + 1}
    return buildList {
        for (index in originalList) {
            add(index + 1)
        }
    }
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

    //Ex1:
    fetchData {
        append(" - Processed")
        println(this.toString())
    }

    // Ex2:
    val button = Button()

    button.onEvent {
        if (!isRightClick && amount == 2) {
            println("Double click!")
        }
    }

    //Ex3:
    val originalList = listOf(1, 2, 3)
    val newList = originalList.incremented()
    println(newList)
}