package sort

/**
 * This function implements the Shaker Sort.
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance       O(n2)
 * Best-case performance        O(n)
 * Average-case performance     O(n2)
 * Worst-case space complexity  O(n2)
 */
fun <T : Comparable<T>> shakerSort(arr: Array<T>) {
    var left = 0
    var right = arr.lastIndex
    var swapped: Boolean

    do {
        swapped = false

        for (i in left until right) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }

        if (!swapped) {
            break
        }

        swapped = false
        right--

        for (i in right downTo left) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }

        left++
    } while (swapped)
}
