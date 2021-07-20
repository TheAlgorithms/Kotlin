package dynamicProgramming

import kotlin.math.max

typealias Weight = Int
typealias Value = Int
typealias Item = Pair<Weight, Value>

fun maxValueOfKnapsack01(knapsackMaxWeight: Int, items: List<Item>): Int {
    val lookupTable = IntArray(knapsackMaxWeight + 1)

    for (item in items) {
        for (capacity in (0..knapsackMaxWeight).reversed()) {
            val (weight, value) = item

            if (weight <= capacity) {
                lookupTable[capacity] = max(lookupTable[capacity], lookupTable[capacity - weight] + value)
            }
        }
    }

    return lookupTable.last()
}
