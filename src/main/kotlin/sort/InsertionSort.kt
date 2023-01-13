package sort

/**
 * This method implements the Generic Insertion Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 * Average performance	O(n^2)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> insertionSort(array: Array<T>) {
    val size = array.size - 1

    for (i in 1..size) {
        val key = array[i]
        var idx = i

        for (j in i - 1 downTo 0) {
            if (array[j].compareTo(key) > 0) {
                array[j + 1] = array[j]
                idx = j
            } else {
                break
            }
        }

        array[idx] = key
    }
}