package sort

/**
 * This method implements the Generic Brick Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 * Average performance	O(n^2)
 * Worst-case space complexity	O(1)
 **/

fun <T : Comparable<T>>  oddEvenSort(array: Array<T>) {
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        var temp : Comparable<T>


        var i = 1
        while (i <= array.size - 2) {
            if (array[i] > array[i + 1]) {
                temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
                isSorted = false
            }
            i += 2
        }
        var j = 0
        while (j <= array.size - 2) {
            if (array[j] > array[j + 1]) {
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                isSorted = false
            }
            j += 2
        }
    }
    return
}