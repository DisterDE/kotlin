package level3.lesson5

import java.util.concurrent.Executors
import kotlin.random.Random.Default.nextInt

private const val CARS_COUNT = 4

internal fun main() {
    println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!")

    val starter = Starter()
    val finisher = Finisher(CARS_COUNT)
    val preparer = Preparer(CARS_COUNT, starter, finisher)

    val executorService = Executors.newFixedThreadPool(CARS_COUNT)

    val race = Race(
        Road(60),
        Tunnel(CARS_COUNT),
        Road(40)
    )

    List(CARS_COUNT) {
        preparer.getCar(race, nextInt(20, 30))
    }.forEach {
        executorService.execute(it)
    }

    preparer.waitAllCars()

    println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!")
    starter.start()

    finisher.waitAllCars()
    println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!")

    executorService.shutdown()
}
