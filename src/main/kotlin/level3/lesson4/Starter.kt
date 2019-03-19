import kotlin.concurrent.thread

private const val PRINT_COUNT = 5

fun main() {
    printOrder()
}

private fun printOrder() {
    Printer.count = PRINT_COUNT
    
    val threads = mutableListOf<Thread>()
    threads.add(
        thread(start = true) {
            Printer(Letter.A).print()
        }
    )
    threads.add(
        thread(start = true) {
            Printer(Letter.B).print()
        }
    )
    threads.add(
        thread(start = true) {
            Printer(Letter.C).print()
        }
    )

    threads.forEach { it.join() }
}
