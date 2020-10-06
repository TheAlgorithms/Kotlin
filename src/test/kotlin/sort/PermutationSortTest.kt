package sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class PermutationSortTest {

    @Test
    fun testPermutationSort1() {
        val input = listOf('d', 'b', 'e', 'a', 'f', 'c')
	val output = permutationSort(input)
        assertArrayEquals(output, listOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testPermutationSort2() {
        val input2 = listOf("first", "second", "third", "fourth", "fifth", "sixth")
        val output2 = permutationSort(input2)
        assertArrayEquals(output2, listOf("first", "second", "third", "fourth", "fifth", "sixth"))
    }

}
