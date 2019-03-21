package level3.lesson5

import java.util.concurrent.Semaphore

sealed class Stage {
    internal abstract val length: Int
    internal abstract val description: String

    internal abstract fun go(c: Car)
}

internal class Tunnel(carsCount: Int) : Stage() {
    override val length = 80
    override val description = "Тоннель $length метров"
    private val carsLimit = Semaphore(carsCount / 2, true)

    override fun go(c: Car) {
        println("${c.name} готовится к этапу(ждет): " + description)
        carsLimit.acquire()
        System.out.println("${c.name} начал этап: " + description)
        Thread.sleep(length / c.speed * 1000L)
        carsLimit.release()
    }
}

internal class Road(override val length: Int) : Stage() {
    override val description = "Дорога $length метров"

    override fun go(c: Car) {
        println("${c.name} начал этап: $description")
        Thread.sleep(length / c.speed * 1000L)
        println("${c.name} закончил этап: $description")
    }
}
