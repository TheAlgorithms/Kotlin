package search

/**
 * Linear search is an algorithm which finds the position of a target value within an array (Usually unsorted)
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity	O(1)
 */

/**
 * @param array is an array where the element should be found
 * @param key is an element which should be found
 * @return index of the element
 */
fun <T : Comparable<T>> linearSearch(array: Array<T>, key: T): Int {
    return linearSearchImpl(array, key)
}

/**
 * @param array The array to search
 * @param key The element you are looking for
 * @return the location of the key or -1 if the element is not found
 **/
fun <T : Comparable<T>> linearSearchImpl(array: Array<T>, key: T): Int {
    for (i in array.indices) {
        if (array[i].compareTo(key) == 0) {
            return i
        }
    }

    return -1
}
