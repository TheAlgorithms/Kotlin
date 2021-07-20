package sort

/**
 * This method implements the Generic Shell Sort
 *
 * @param array The array to be sorted
 *
 * Worst-case performance	O(n^4/3)
 * Best-case performance	O(n log n)
 * Average performance	O(n^4/3)
 * Worst-case space complexity	O(1)
 **/
fun <T: Comparable<T>> shellSort(array: Array<T>) {
    var h = 1
    while (h < array.size/3) h = 3*h+1
    while (h != 0) {
        for (i in h until array.size) {
            for (j in i downTo h) {
                if (array[j] < array[j-h]) {
                    swapElements(array,j,j-h)
                }
            }
        }
        h /= 3
    }

}