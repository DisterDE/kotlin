package algorithms.lesson3.stack

private const val TEST_STRING = "hello"
private const val TEST_STRING_LENGTH = TEST_STRING.length

fun main() {
    val stack: Stack = StackImpl(TEST_STRING_LENGTH)

    TEST_STRING.forEach { stack += it }

    println("Stack: ")
    stack.display()

    println("Peek: ${stack.peek()}")

    println("Reverse and clear: ")
    stack.reverseAndClear()
}

operator fun Stack.plusAssign(value: Char) {
    if (!isFull()) {
        push(value)
    }
}

fun Stack.reverseAndClear() {
    while (!isEmpty()) {
        println(pop())
    }
}