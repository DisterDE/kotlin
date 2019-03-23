package level3.lesson5

import java.util.concurrent.CyclicBarrier
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.random.Random.Default.nextLong

internal class Car internal constructor(
    private val race: Race,
    internal val speed: Int,
    private val barrier: CyclicBarrier,
    private val start: Starter,
    private val finisher: Finisher
)
    : Runnable {

    companion object {
        private var carsCount = 0
        private var hasWinner = AtomicBoolean(false)
    }

    init {
        carsCount++
    }

    internal val name = "Участник #$carsCount"

    override fun run() {
        prepare()
        waitAllCars()
        start.waitAllCars()
        start()
    }

    private fun waitAllCars() {
        barrier.await()
    }

    private fun start() {
        race.stages.forEach { it.go(this) }
        checkWin()
        finisher.finish()
    }

    private fun prepare() {
        println("$name готовится")
        preparing()
        println("$name готов")
    }

    private fun preparing() {
        Thread.sleep(nextLong(1001))
    }

    private fun checkWin() {
        if (!hasWinner.getAndSet(true)) {
            println("$name - WIN")
        }
    }
}
