package sort

import kotlin.collections.shuffle

/**
 * This method implements the Randomized Bogo Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance	Unbounded
 * Best-case performance	O(n)
 * Average performance	O(n!)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> bogoSort(array: Array<T>) {
    while (!array.isSorted()) array.shuffle()
}

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
    for (i in 0 until this.size - 1) {
        if (this[i] > this[i + 1]) return false
    }
    return true
}