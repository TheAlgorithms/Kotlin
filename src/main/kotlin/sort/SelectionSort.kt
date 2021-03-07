package sort

/**
 * This method implements the Generic Selection Sort
 *
 * @param array The array to be sorted
 * Sorts the array by repeatedly finding the minimum element from unsorted part and putting in the beginning
 *
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n^2)
 * Average performance	O(n^2)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> selectionSort(array: Array<T>) {
    val length = array.size - 1

    for (i in 0..length) {
        var idx = i
        for (j in i + 1..length) {
            if (array[j] < array[idx]) {
                idx = j
            }
        }

        swapElements(array, i, idx)
    }
}
