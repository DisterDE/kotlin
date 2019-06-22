package algorithms.lesson3.queue

class QueueImpl(maxSize: Int) : Queue {
    private val data = IntArray(maxSize)
    private var size = 0
    private var front = DEFAULT_FRONT
    private var rear = DEFAULT_REAR

    override fun add(value: Int) {
        if (rear == data.size - 1) {
            rear = DEFAULT_REAR
        }

        data[++rear] = value
        size++
    }

    override fun remove(): Int {
        val frontValue = data[front++]
        if (front == data.size) {
            front = DEFAULT_FRONT
        }
        size--
        return frontValue
    }

    override fun peek() = data[front]

    override fun isEmpty() = size == 0

    override fun isFull() = size == data.size

    override fun getSize() = size

    override fun display() {
        var currentFront = front
        var currentSize = size
        while (currentSize > 0) {
            println("${data[currentFront++]} ")
            if (currentFront == data.size) {
                currentFront = DEFAULT_FRONT
            }
            currentSize--
        }
        println()
    }

    companion object {
        private const val DEFAULT_FRONT = 0
        private const val DEFAULT_REAR = -1
    }
}