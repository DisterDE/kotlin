package algorithms.lesson2


class ArrayImpl : Array {

    private var array = IntArray(INITIAL_ARRAY_SIZE)
    private var size = 0

    override fun add(value: Int): Boolean {
        if (isFull()) {
            checkGrow()
        }
        array[size++] = value
        return true
    }

    override fun checkGrow() {
        array = array.copyOf(array.size + (array.size / 2))
    }

    override fun remove(value: Int): Boolean {
        val index = indexOf(value)
        return if (index != -1) {
            removeByIndex(index)
            true
        } else {
            false
        }
    }

    override fun removeByIndex(index: Int): Boolean {
        if (index < 0 || index >= size) {
            return false
        }

        for (i in index until size) {
            array[i] = array[i + 1]
        }
        size--
        return true
    }

    override fun find(value: Int): Boolean {
        return indexOf(value) != -1
    }

    override fun indexOf(value: Int): Int {
        for (i in 0 until size) {
            if (array[i] == value) {
                return i
            }
        }
        return -1
    }

    override fun display() {
        println(this)
    }

    override fun copy(): IntArray {
        return array.copyOf()
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun isFull(): Boolean {
        return size == array.size
    }

    override fun getSize(): Int {
        return size
    }

    override fun toString(): String {
        return array.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]"
        ) { it.toString() }
    }

    companion object {
        private const val INITIAL_ARRAY_SIZE = 10
    }
}

