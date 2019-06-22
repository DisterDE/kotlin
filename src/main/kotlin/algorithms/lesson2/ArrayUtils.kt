package algorithms.lesson2

object ArrayUtils {
    fun sortBubble(arr: IntArray) {
        for (i in 0 until arr.size - 1) {
            for (j in 0 until arr.size - 1 - i) {
                if (arr[j] > arr[j + 1]) {
                    changeElements(arr, j, j + 1)
                }
            }
        }
    }

    fun sortSelection(arr: IntArray) {
        for (i in 0 until arr.size - 1) {
            var minElementIndex = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j
                }
            }
            changeElements(arr, i, minElementIndex)
        }
    }

    fun sortInsertion(arr: IntArray) {
        var out = 1
        var `in`: Int
        while (out < arr.size) {
            val temp = arr[out]
            `in` = out
            while (`in` > 0 && arr[`in` - 1] >= temp) {
                arr[`in`] = arr[`in` - 1]
                `in`--
            }
            arr[`in`] = temp
            out++
        }
    }

    private fun changeElements(arr: IntArray, indexA: Int, indexB: Int) {
        val tmp = arr[indexA]
        arr[indexA] = arr[indexB]
        arr[indexB] = tmp
    }
}