package level2.lesson1.competitors

import level2.lesson1.actions.CanJump
import level2.lesson1.actions.CanRun
import level2.lesson1.actions.CanSwim
import kotlin.random.Random

internal val random = Random

abstract class Competitor(
    internal val name: String,
    private val runDistance: Int,
    private val jumpHeight: Int,
    private val swimDistance: Int
) : CanRun, CanJump, CanSwim {
    internal var onDistance = true

    override fun run(distance: Int) {
        if (distance <= runDistance) {
            println("$name пробежал дистанцию")
        } else {
            println("$name не смог пробежать дистанцию и выбыл из соревнования")
            onDistance = false
        }
    }

    override fun jump(height: Int) {
        if (height <= jumpHeight) {
            println("$name взял высоту")
        } else {
            println("$name не смог взять высоту и выбыл из соревнования")
            onDistance = false
        }
    }

    override fun swim(distance: Int) {
        if (distance <= swimDistance) {
            println("$name проплыл дистанцию")
        } else {
            println("$name не смог проплыть дистанцию и выбыл из соревнования")
            onDistance = false
        }
    }
}