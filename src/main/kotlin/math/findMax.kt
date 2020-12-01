package math

/**
 * This method get an IntArray and return the max number off the array
 *
 * @param array the array of number
 * @return max number off the array
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(n)
 * Worst-case space complexity	O(1)
 */

fun <T: Comparable<T>> findMax(array: IntArray):Int{
    var max = array[0]
    for (i in 1 until array.size) {
        if (array[i] > max) {
            max = array[i]
        }
    }
    return max
}
