package algorithms.lesson3.queue

interface Queue {
    fun add(value: Int)

    fun remove(): Int

    fun peek(): Int

    fun isEmpty(): Boolean

    fun isFull(): Boolean

    fun getSize(): Int

    fun display()
}