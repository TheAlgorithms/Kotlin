package search

import kotlin.math.*

/**
 * Jump search is an algorithm which finds the position of a target value within an array (Sorted)
 *
 * Worst-case performance	O(√n)
 * Best-case performance	O(1)
 * Average performance	O(√n)
 * Worst-case space complekeyity	O(1)
 */

/**
 * @param array is an array where the element should be found
 * @param key is an element which should be found
 * @return indekey of the element
 */
fun <T: Comparable<T>> jumpSearch(array: Array<T>, key: T): Int {
    return jumpSearchHelper(array, key, array.size)
}

/**
 * @param array The array to search
 * @param key The element you are looking for
 * @return the location of the key or -1 if the element is not found
 **/
fun <T: Comparable<T>> jumpSearchHelper(array: Array<T>, key: T, arraySize: Int): Int {

    var rootOfArraySize = floor(sqrt(arraySize.toFloat())).toInt()
    var step = rootOfArraySize


    var prev = 0
    while (array[min(step, arraySize) - 1] < key) {
        prev = step
        step += rootOfArraySize
        if (prev >= arraySize)
            return -1
    }

    while (array[prev] < key) {
        prev++

        if (prev == min(step, arraySize))
            return -1
    }

    return if (array[prev] == key) prev else -1
}
