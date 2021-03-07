package search

/**
 * Binary search is an algorithm which finds the position of a target value within an array (Sorted)
 *
 * Worst-case performance	O(log(n))
 * Best-case performance	O(1)
 * Average performance	O(log(n))
 * Worst-case space complexity	O(1)
 */

/**
 * @param array is an array where the element should be found
 * @param key is an element which should be found
 * @return index of the element
 */
fun <T : Comparable<T>> binarySearch(array: Array<T>, key: T): Int {
    return binarySearchHelper(array, key, 0, array.size - 1)
}

/**
 * @param array The array to search
 * @param key The element you are looking for
 * @return the location of the key or -1 if the element is not found
 **/
fun <T : Comparable<T>> binarySearchHelper(array: Array<T>, key: T, start: Int, end: Int): Int {
    if (start > end) {
        return -1
    }

    val mid = start + (end - start) / 2

    return when {
        array[mid].compareTo(key) == 0 -> mid
        array[mid].compareTo(key) > 0 -> binarySearchHelper(array, key, start, mid - 1)
        else -> binarySearchHelper(array, key, mid + 1, end)
    }
}
