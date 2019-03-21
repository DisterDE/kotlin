package level3.lesson6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ArrayUtilsTest {

    @Test
    fun `test task1 empty array`() {
        Assertions.assertThrows(RuntimeException::class.java) {
            getArrAfterLastFour(intArrayOf())
        }
    }

    @Test
    fun `test task1 array without 4`() {
        Assertions.assertThrows(RuntimeException::class.java) {
            getArrAfterLastFour(intArrayOf(1, 2, 3))
        }
    }

    @ParameterizedTest
    @MethodSource("task1Params")
    fun `test task1 with params`(data: IntArray, result: IntArray) {
        Assertions.assertArrayEquals(result, getArrAfterLastFour(data))
    }

    @ParameterizedTest
    @MethodSource("task2Params")
    fun `test task2 with params`(data: IntArray, result: Boolean) {
        Assertions.assertEquals(result, isArrContainsOnly1And4(data))
    }

    companion object {
        @JvmStatic
        fun task1Params() =
            listOf(
                Arguments.of(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf()
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4, 5),
                    intArrayOf(5)
                ),
                Arguments.of(
                    intArrayOf(1, 2, 4, 3, 4, 5, 6),
                    intArrayOf(5, 6)
                )
            )

        @JvmStatic
        fun task2Params() =
            listOf(
                Arguments.of(
                    intArrayOf(1, 1, 4),
                    true
                ),
                Arguments.of(
                    intArrayOf(1, 2, 3, 4),
                    false
                ),
                Arguments.of(
                    intArrayOf(),
                    false
                )
            )
    }
}
