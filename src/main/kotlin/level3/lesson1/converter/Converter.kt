package level3.lesson1.converter

fun <T> Array<T>.transformToList(): MutableList<T> {
    return this.toMutableList()
}

fun main() {
    val numArr = arrayOf(1, 2, 3)
    println("numArr = ${numArr.joinToString(prefix = "[", postfix = "]")}")

    val numList = numArr.transformToList()
    numList.add(5)
    println("numList = ${numList.joinToString(prefix = "[", postfix = "]")}")
}