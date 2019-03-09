package level2.lesson1.competitors

import kotlin.random.nextInt

internal sealed class Animal(
    type: String,
    name: String,
    runDistance: Int,
    jumpHeight: Int,
    swimDistance: Int
) : Competitor(
    "$type $name",
    runDistance,
    jumpHeight,
    swimDistance
)

internal class Cat(
    name: String
) : Animal(
    "Кот",
    name,
    random.nextInt(500..800),
    random.nextInt(5..8),
    0
) {
    override fun swim(distance: Int) {
        println("$name не умеет плавать и выбывает из соревнования")
        onDistance = false
    }
}

internal class Dog(
    name: String
) : Animal(
    "Пёс",
    name,
    random.nextInt(600..1000),
    random.nextInt(5..7),
    random.nextInt(250..500)
)