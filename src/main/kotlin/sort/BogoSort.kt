package sort

/**
 * This method implements the Generic Bogo Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order by permuting its input until it finds one that is sorted
 *
 * Worst-case performance	O((n+1)!)
 * Best-case performance	O(n)
 * Average performance	O((n+1)!)
 * Worst-case space complexity	O(1)
 **/
fun <T : Comparable<T>> bogoSort(array: Array<T>) {
    while (!isSorted(array)) array.shuffle()
}

/**
 * This method checks if the array is sorted
 *
 * @param array The array to be checked
 * @return true if the array is sorted
 **/
fun <T : Comparable<T>> isSorted(array: Array<T>): Boolean {
    val size = array.size
    if (size < 2) return true
    for (i in 1 until size)
        if (array[i] < array[i - 1]) return false
    return true
}