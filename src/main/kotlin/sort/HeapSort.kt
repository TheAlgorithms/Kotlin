package sort

/**
 * This function implements the Heap Sort.
 *
 * @param array The array to be sorted
 * Sorts the array in increasing order
 *
 * Worst-case performance       O(n*log(n))
 * Best-case performance        O(n*log(n))
 * Average-case performance     O(n*log(n))
 * Worst-case space complexity  O(1) (auxiliary)
 */
fun <T : Comparable<T>> heapSort(array: Array<T>) {
    buildMaxHeap(array)
    transformMaxHeapToSortedArray(array)
}

/**
 * This function changes the element order of the array to represent a max
 * binary tree.
 *
 * @param array The array containing the elements
 * @param index Index of the currently largest element
 */
fun <T : Comparable<T>> maxheapify(array: Array<T>, heapSize: Int, index: Int) {
    val left = 2 * index + 1
    val right = 2 * index + 2
    var largest = index

    if (left < heapSize && array[left] > array[largest])
        largest = left
    if (right < heapSize && array[right] > array[largest])
        largest = right
    if (largest != index) {
        swapElements(array, index, largest)
        maxheapify(array, heapSize, largest)
    }
}

/**
 * Arrange the elements of the array to represent a max heap.
 *
 * @param array The array containing the elements
 */
private fun <T : Comparable<T>> buildMaxHeap(array: Array<T>) {
    val n = array.size
    for (i in (n / 2 - 1) downTo 0)
        maxheapify(array, n, i)
}

/**
 * Arrange the elements of the array, which should be in order to represent a
 * max heap, into ascending order.
 *
 * @param array The array containing the elements (max heap representation)
 */
private fun <T : Comparable<T>> transformMaxHeapToSortedArray(array: Array<T>) {
    for (i in (array.size - 1) downTo 0) {
        swapElements(array, i, 0)
        maxheapify(array, i, 0)
    }
}

