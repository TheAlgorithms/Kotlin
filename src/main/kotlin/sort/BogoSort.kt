package sort

import kotlin.random.Random.Default.nextInt

/**
 * This method implements the Generic BogoSort
 *
 * @param array The array to be sorted
 * Checks if array is in increasing order, shuffles until it is
 *
 * Worst-case performance	    Unbounded
 * Best-case performance	    O(n)
 * Average performance	        O((n+1)!)
 * Worst-case space complexity	O(n)
 **/
fun <T: Comparable<T>> bogoSort(array: Array<T>) {
    val length = array.size - 1

    var i = 0
    var testNum = 1
    while ( i != length ) {
        if (array[i] > array[i+1]) {
            array.shuffle()
            i = 0
            testNum ++
        } else {
            i ++
        }
    }
}

/**
 * This method shuffles elements in array in-place
 **/
fun <T> Array<T>.shuffle() {
    for (i in this.indices) {
        val randomIndex = nextInt(this.size)
        val tmpValue = this[randomIndex]
        this[randomIndex] = this[i]
        this[i] = tmpValue
    }
}