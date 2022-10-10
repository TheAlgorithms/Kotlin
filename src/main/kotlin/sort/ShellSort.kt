package sort

/**
 * This method implements the Shell Sort
 *
 * @param array The array to be sorted
 * @param gaps The gap sequence to be used. Default is [701, 301, 132, 57, 23, 10, 4, 1] (Marcin Ciura's gap sequence)
 * Sorts the array by decreasing the gap over which it compares elements after each iteration
 *
 * Worst-case performance	O(n^2) (worst known worst case gap sequence)
 *                          O(n log^2 n) (best known worst case gap sequence)
 * Best-case performance	O(n log n) (most gap sequences)
 *                          O(n log^2 n) (best known worst-case gap sequence)
 * Average performance	    depends on gap sequence
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> shellSort(array: Array<T>, gaps: Array<Int> = arrayOf(701, 301, 132, 57, 23, 10, 4, 1)) {
    for (gap in gaps) {
        if (gap >= array.size)
            continue

        for (i in gap until array.size) {
            for (j in i downTo gap step gap) {
                if (array[j] < array[j - gap]) {
                    swapElements(array, j, j - gap)
                }
            }
        }
    }
}
