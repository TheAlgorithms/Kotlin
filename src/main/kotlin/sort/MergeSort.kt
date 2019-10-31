package sort

/**
 * This function implements Merge Sort
 *
 * @param array The array to be sorted
 * It is a Divide and Conquer algorithm. It sorts the array by dividing it into two halves and comparing the elements.
 *
 * Worst-case performance	    O(n log n)
 * Best-case performance	    O(n log n)
 * Average performance      	O(n log n)
 * Worst-case space complexity	O(n)
 */
fun <T : Comparable<T>> mergeSort(array: Array<T>, start: Int, end: Int) {

    val temp = arrayOfNulls<Comparable<*>>(array.size) as Array<T>

    if (start < end) {
        val mid = start + (end - start) / 2
        mergeSort(array, start, mid)
        mergeSort(array, mid + 1, end)
        merge(array, temp, start, mid, end)
    }
}

/**
 * This function merges the two halves after comparing them
 * @param array The array to be sorted
 * @param temp The temp array containing the values
 * @param start Starting index of the array
 * @param mid Middle index of the array
 * @param end Ending index of the array
 */
fun <T : Comparable<T>> merge(array: Array<T>, temp: Array<T>, start: Int, mid: Int, end: Int) {

    System.arraycopy(array, start, temp, start, end - start + 1)

    var i = start
    var j = mid + 1
    var k = start

    while (i <= mid && j <= end) {
        if (temp[i] < temp[j]) {
            array[k++] = temp[i++]
        } else {
            array[k++] = temp[j++]
        }
    }

    while (i <= mid) {
        array[k++] = temp[i++]
    }

    while (j <= end) {
        array[k++] = temp[j++]
    }
}