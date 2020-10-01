package dynamicProgramming

import org.junit.Test

internal class Knapsack01Test {

    @Test
    fun knapsack01Test1() {
        val knapsackMaxWeight = 15
        val items = listOf(Pair(10, 7), Pair(9, 8), Pair(5, 6))
        assert(maxValueOfKnapsack01(knapsackMaxWeight, items) == 14)
    }

    @Test
    fun knapsack01Test2() {
        val knapsackMaxWeight = 25
        val items = listOf(Pair(10, 2), Pair(29, 10), Pair(5, 7), Pair(5, 3), Pair(5, 1), Pair(24, 12))
        assert(maxValueOfKnapsack01(knapsackMaxWeight, items) == 13)
    }
}
