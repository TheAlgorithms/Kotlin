package search

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class InterpolationSearchTest(
    private val sortedArray: IntArray,
    private val searchElement: Int,
    private val expected: Int
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(intArrayOf(1, 2, 3, 4), 2, 1),
            arrayOf(intArrayOf(1, 2, 4, 8, 16), 4, 2),
            arrayOf(intArrayOf(1, 2, 4, 8, 16), 5, -1),
            arrayOf(intArrayOf(1, 2, 4, 8, 16), 1, 0),
            arrayOf(intArrayOf(1, 2, 4, 8, 16), 16, 4),
            arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 12, 16), 12, 8),
            arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 13, 16), 13, 8),
            arrayOf(
                intArrayOf(
                    1,
                    2,
                    3,
                    4,
                    5,
                    6,
                    7,
                    8,
                    9,
                    10,
                    11,
                    13,
                    1024,
                    2048,
                    4096,
                    5000,
                    100_000,
                    200_000,
                    300_000,
                    400_000
                ), 5000, 15
            ),
        )
    }

    @Test(timeout = 1000)
    fun testInterpolationSearch() {
        assertEquals(expected, interpolationSearch(sortedArray, searchElement))
    }
}
