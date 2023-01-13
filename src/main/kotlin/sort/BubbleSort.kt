package sort

/**
 * This method implements the Generic Bubble Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 * Average performance	O(n^2)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> bubbleSort(array: Array<T>) {
    val length = array.size - 1

    for (i in 0..length) {
        var isSwapped = false
        for (j in 1..length) {
            if (array[j] < array[j - 1]) {
                isSwapped = true
                swapElements(array, j, j - 1)
            }
        }

        if (!isSwapped) break
    }
}

/**
 * This method swaps the element at two indexes
 *
 * @param array The array containing the elements
 * @param idx1 Index of first element
 * @param idx2 Index of second element
 * Swaps the element at two indexes
 **/
fun <T : Comparable<T>> swapElements(array: Array<T>, idx1: Int, idx2: Int) {
    array[idx1] = array[idx2].also {
        array[idx2] = array[idx1]
    }
}
