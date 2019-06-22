package algorithms.lesson2

import kotlin.random.Random.Default.nextInt
import kotlin.system.measureTimeMillis

private const val ARRAY_TEST_SIZE = 10_000

fun main() {
    val arr: Array = ArrayImpl()

    for (i in 0 until ARRAY_TEST_SIZE) {
        arr.add(nextInt(ARRAY_TEST_SIZE) + 1)
    }

    val arr1 = arr.copy()
    val arr2 = arr.copy()
    val arr3 = arr.copy()

    println("Bubble sort: " + measureTimeMillis {
        ArrayUtils.sortBubble(arr1)
    })

    println("Selection sort: " + measureTimeMillis {
        ArrayUtils.sortSelection(arr2)
    })

    println("Insertion sort: " + measureTimeMillis {
        ArrayUtils.sortInsertion(arr3)
    })
}