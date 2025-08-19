package sort

/**
 * This method implements the Radix Sort
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order.
 *
 * Worst-case performance	O(nw)
 * Best-case performance	O(n + w)
 * Average performance	O(nw)
 * Worst-case space complexity	O(w + n)
 * Here n is the number of elements and w is element's length.
 **/
fun radixSort(array: Array<Int>) {
    if (array.isEmpty()) return
    val max = array.max()!!
    var exp = 1
    while (max / exp > 0) {
        countSort(array, exp)
        exp *= 10
    }
}


/**
 * This method performs count sort
 *
 * @param array The array to be sorted
 * @param exp It represents the digit used for sorting
 * Sorts the array in increasing order
 *
 **/
fun countSort(array: Array<Int>, exp: Int) {
    val output = Array(array.size) { 0 }
    val count = Array(10) { 0 }
    array.forEach { count[(it / exp) % 10]++ }
    for (i in 1..9) {
        count[i] += count[i - 1]
    }
    for (i in array.size - 1 downTo 0) {
        output[count[(array[i] / exp) % 10] - 1] = array[i]
        count[(array[i] / exp) % 10]--
    }
    for (i in array.indices) {
        array[i] = output[i]
    }
}