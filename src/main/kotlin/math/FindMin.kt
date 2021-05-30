package math

/**
 * This method get an IntArray and return the min number of the array
 *
 * @param array the array of number
 * @return min number of the array
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity	O(1)
 */

fun <T: Comparable<T>> findMin(array: IntArray):Int{
    var min = array[0]
    for (i in 1 until array.size) {
        if (array[i] < min) {
            min = array[i]
        }
    }
    return min
}
