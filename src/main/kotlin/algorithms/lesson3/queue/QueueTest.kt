package algorithms.lesson3.queue

private const val QUEUE_TEST_SIZE = 5

fun main() {
    val queue = QueueImpl(QUEUE_TEST_SIZE)

    queue += 10
    queue += 20
    queue += 30
    queue += 40
    queue += 50

    println("Queue:")
    queue.display()

    queue.deleteElement()
    println("Peek: ${queue.peek()}")
    queue.deleteElement()

    queue += 60
    queue += 70

    println("Queue:")
    queue.display()

    while (!queue.isEmpty()) {
        queue.deleteElement()
    }
}

private operator fun Queue.plusAssign(value: Int) {
    if (!isFull()) {
        add(value)
        println("$value has been added.")
    }
}

private fun Queue.deleteElement() {
    if (!isEmpty()) {
        println("${remove()} has been removed.")
    }
}