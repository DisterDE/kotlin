package level3.lesson1.swapper

@Throws(IllegalArgumentException::class)
fun <T> Array<T>.swapElements(index1: Int, index2: Int) {
    if (index1 !in indices) {
        throw IllegalArgumentException("Array hasn't element [$index1]")
    }

    if (index2 !in indices) {
        throw IllegalArgumentException("Array hasn't element [$index2]")
    }

    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    val wordArr = arrayOf("H", "e", "l", "l", "o")

    try {
        wordArr.swapElements(0, 2)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }

    println(wordArr.joinToString(prefix = "[", postfix = "]"))
}