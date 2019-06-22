package algorithms.lesson1

interface Array {
    fun add(value: Int): Boolean

    fun checkGrow()

    fun remove(value: Int): Boolean

    fun removeByIndex(index: Int): Boolean

    fun find(value: Int): Boolean

    fun indexOf(value: Int): Int

    fun display()

    fun copy(): IntArray

    fun isEmpty(): Boolean

    fun isFull(): Boolean

    fun getSize(): Int
}