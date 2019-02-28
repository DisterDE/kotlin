package level3.lesson1.fruitboxes

import kotlin.math.abs

class Box<E : Fruit> {
    private val fruitList: MutableList<E>

    init {
        fruitList = ArrayList()
    }

    fun add(fruit: E): Boolean {
        return fruitList.add(fruit)
    }

    fun compare(other: Box<*>): Boolean {
        return abs(this.getWeight() - other.getWeight()) < 0.00001
    }

    fun getWeight(): Double {
        return fruitList.sumByDouble { it.weight }
    }

    fun moveFruitsTo(other: Box<E>) {
        other.fruitList.addAll(this.fruitList)
        this.fruitList.clear()
    }
}