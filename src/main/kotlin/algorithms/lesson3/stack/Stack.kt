package algorithms.lesson3.stack

interface Stack {
    fun push(value: Char)

    fun pop(): Char

    fun peek(): Char

    fun isEmpty(): Boolean

    fun isFull(): Boolean

    fun display()
}