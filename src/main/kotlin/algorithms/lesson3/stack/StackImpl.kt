package algorithms.lesson3.stack

class StackImpl(maxSize: Int) : Stack {
    private val data = CharArray(maxSize)
    private var top = -1

    override fun push(value: Char) {
        data[++top] = value
    }

    override fun pop(): Char {
        return data[top--]
    }

    override fun peek(): Char {
        return data[top]
    }

    override fun isEmpty(): Boolean {
        return top == -1
    }

    override fun isFull(): Boolean {
        return top == data.size - 1
    }

    override fun display() {
        for (i in 0..top) {
            println(data[i])
        }
    }
}