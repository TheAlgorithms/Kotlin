package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ShellSortTest {

    @Test
    fun testShellSort1() {
        val intarray = arrayOf(12, 45, -1, 2, 100)
        shellSort(intarray)

        assertArrayEquals(intarray, arrayOf(-1, 2, 12, 45, 100))
    }

    @Test
    fun testShellSort2() {
        val alpharray = arrayOf("D", "Q", "Z", "A", "R")
        shellSort(alpharray)

        assertArrayEquals(alpharray, arrayOf("A", "D", "Q", "R", "Z"))
    }
}