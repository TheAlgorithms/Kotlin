package sort

/**
 * This method implements the Quick Sort
 *
 * @param array The array to be sorted
 * It is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
 *
 * Worst-case performance	    O(n^2)
 * Best-case performance	    O(nLogn)
 * Average performance      	O(nLogn)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> quickSort(array: Array<T>, low: Int, high: Int) {
    if (low < high) {
        val pivot = partition(array, low, high)
        quickSort(array, low, pivot - 1)
        quickSort(array, pivot, high)
    }
}

/**
 * This method finds the pivot index for an array
 *
 * @param array The array to be sorted
 * @param low The first index of the array
 * @param high The last index of the array
 *
 * */
fun <T : Comparable<T>> partition(array: Array<T>, low: Int, high: Int): Int {

    var left = low
    var right = high
    val mid = (left + right) / 2
    val pivot = array[mid]

    while (left <= right) {
        while (array[left] < pivot) {
            left++
        }

        while (array[right] > pivot) {
            right--
        }

        if (left <= right) {
            swapElements(array, left, right)
            left++
            right--
        }
    }
    return left
}