package level3.lesson6

internal fun getArrAfterLastFour(nums: IntArray): IntArray {
    val index = nums.lastIndexOf(4)

    if (index == -1) {
        throw RuntimeException("Array is not valid: ${nums.joinToString()}")
    }

    val result = nums.drop(index + 1)

    return result.toIntArray()
}

internal fun isArrContainsOnly1And4(nums: IntArray): Boolean {
    return nums.isNotEmpty() && nums.all { it == 1 || it == 4 }
}
