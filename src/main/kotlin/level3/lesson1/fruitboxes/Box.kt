package level3.lesson1.fruitboxes

import kotlin.math.abs

class Box<E : Fruit> {
    private val fruitList: MutableList<E>

    init {
        fruitList = ArrayList()
    }

    internal val weight: Double
        get() = fruitList.sumByDouble { it.weight }


    fun add(fruit: E): Boolean {
        return fruitList.add(fruit)
    }

    fun compare(other: Box<*>): Boolean {
        return abs(this.weight - other.weight) < 0.00001
    }

    fun moveFruitsTo(other: Box<E>) {
        fruitList.forEach { other.add(it) }
        fruitList.clear()
    }
}