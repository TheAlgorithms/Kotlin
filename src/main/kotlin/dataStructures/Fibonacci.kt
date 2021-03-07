package dataStructures

/**
 * The Fibonacci numbers form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1
 */

/**
 * Complexity Analysis:
 * 
 * Time complexity: O(n). Each number, starting at 2 up to and
 * including N, is visited, computed and then stored for O(1) access
 * later on.
 *
 * Space complexity: O(n). The size of the stack in memory is
 * proportionate to N.
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
