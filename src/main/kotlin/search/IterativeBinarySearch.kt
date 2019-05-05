package search

import java.util.*

/**
 * This algorithm represents the iterative version of one of the most popular search algorithms
 * It finds the position of a target value within an array
 *
 * Worst-case performance: O(log n)
 * Best-case performance: O(1)
 * Average Performance: O(log n)
 * Worst case space complexity : O(1)
 *
 **/

/**
 * @param arr is an array where the element should be found
 * @param key is an element which should be found in arr
 * @return index of the element
 * Returns -1 if the element is not found
 */
fun <T: Comparable<T>> iterativeBinarySearch(arr: Array<T>, key: T): Int {
    var start = 0
    var end = arr.size - 1
    var mid: Int
    var cmp: Int

    while (start <= end) {
        mid = (start + end) / 2
        cmp = key.compareTo(arr[mid])

        when {
            cmp == 0 -> return mid
            cmp < 0 -> end = --mid
            else -> start = ++mid
        }

    }

    return -1
}


// Only for manual testing
fun main() {

    val rand = Random()
    val size = 100
    val maxElement = 100000

    val integers = Array(size) {
        rand.nextInt(maxElement)
    }.sortedArray()

    val key = integers[rand.nextInt(size-1)]

    val index = iterativeBinarySearch(integers, key)

    println("Element $key was found at $index with array length $size")

    // testing our implementation with built in binary search
    val toCheck = Arrays.binarySearch(integers, key)
    println("Element $key was found at $toCheck with array length $size")

}