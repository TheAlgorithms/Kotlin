package search

import kotlin.math.min
import kotlin.math.sqrt

/**
 * Jump Search is an algorithm which finds the position of a target value within an array (Sorted)
 *
 * Time complexity	O(sqrt(n))
 * space complexity	O(1)
 */

/**
 * @param array is an array where the element should be found
 * @param key is an element which should be found
 * @return index of the element, -1 if element not found.
 */
fun <T : Comparable<T>> jumpSearch(array: Array<T>, key: T): Int {
    val stepSize = sqrt(array.size.toDouble()).toInt()
    var step = stepSize
    var previousStep = 0

    while (array[min(step, array.size) - 1] < key) {
        previousStep = step
        step += stepSize

        if (previousStep >= array.size) {
            return -1
        }
    }

    while (array[previousStep] < key) {
        previousStep += 1
    }
    if (array[previousStep] == key) {
        return previousStep;
    }
    return -1
}


