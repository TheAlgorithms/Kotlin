package dataStructures

/**
 * The Fibonacci numbers form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1
 */

// Create mutableMap to save counted value for a specific index
val answersMap: MutableMap<Long, Long> = mutableMapOf(0L to 0L, 1L to 1L)

/**
 * @param num is index in the Fibonacci sequence
 * @return value of element in Fibonacci sequence
 */
fun fibonacci(num: Long): Long {
    // if the answer is already counted, then return it
    return if (answersMap.containsKey(num)) {
        answersMap[num]!!
    } else {
        answersMap[num] = fibonacci(num - 1L) + answersMap[num - 2L]!!
        answersMap[num]!!
    }
}