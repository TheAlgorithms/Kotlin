package sort

fun <T: Comparable<T>> quickSort(array: Array<T>, low: Int, high: Int) {
    if (low < high) {
        val pivot = partition(array, low, high)
        quickSort(array, low, pivot - 1)
        quickSort(array, pivot, high)
    }
}

fun <T: Comparable<T>> partition(array: Array<T>, low: Int, high: Int): Int {

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