package search

import kotlin.math.min
import kotlin.math.sqrt

/**
 * Jump search implementation
 */

/**
 * @param array is an array where the element should be found
 * @param key is an element which should be found
 * @return index of the element
 */
fun <T: Comparable<T>> jumpSearch(array: Array<T>, key: T): Int {
    val length = array.size /* length of array */
    val blockSize  = sqrt(length.toDouble()).toInt()
    var limit = blockSize
    while (key.compareTo(array[limit]) > 0 && limit < array.size - 1) {
        limit = min(limit + blockSize, (array.size - 1));
    }

    for (i in (limit - blockSize)..limit) {
        if (array[i] === key) { /* execute linear search */
            return i
        }
    }
    return -1
}


