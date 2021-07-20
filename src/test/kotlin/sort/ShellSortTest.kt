package sort


import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ShellSortTest {

    @Test
    fun testShellSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        shellSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testShellSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        shellSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }

    @Test
    fun testShellSort3() {
        val array = arrayOf(20, 5, 16, -1, 6)
        shellSort(array)

        assertArrayEquals(array, arrayOf(-1, 5, 6, 16, 20))
    }
}
