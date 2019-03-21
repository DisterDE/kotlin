package level3.lesson5

import java.util.concurrent.CountDownLatch
import java.util.concurrent.CyclicBarrier

internal class Preparer internal constructor(
    carCount: Int,
    private val starter: Starter,
    private val finisher: Finisher
) {

    private val barrier = CyclicBarrier(carCount + 1)

    internal fun getCar(race: Race, speed: Int): Car {
        return Car(race, speed, barrier, starter, finisher)
    }

    internal fun waitAllCars() {
        barrier.await()
    }
}

internal class Starter {
    private val countDownLatch = CountDownLatch(1)

    internal fun start() {
        countDownLatch.countDown()
    }

    internal fun waitAllCars() {
        countDownLatch.await()
    }
}

internal class Finisher internal constructor(carCount: Int) {
    private val countDownLatch = CountDownLatch(carCount)

    internal fun finish() {
        countDownLatch.countDown()
    }

    internal fun waitAllCars() {
        countDownLatch.await()
    }
}
