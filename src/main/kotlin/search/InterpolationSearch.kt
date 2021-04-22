package search

/**
 * Interpolation search is an algorithm which finds the position of a target value within an array (Sorted)
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(log log n)
 * Worst-case space complexity	O(1)
 */

/**
 * @param arr is an array where the element should be found
 * @param lo array starting index
 * @param hi array ending index
 * @param x is an element which should be found
 * @return index of the element
 */

fun interpolationSearch(arr: IntArray, lo: Int,
                        hi: Int, x: Int): Int {
    val pos: Int

    if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

        pos = (lo
                + ((hi - lo) / (arr[hi] - arr[lo])
                * (x - arr[lo])))

        if (arr[pos] == x) return pos

        if (arr[pos] < x) return interpolationSearch(arr, pos + 1, hi,
                x)

        if (arr[pos] > x) return interpolationSearch(arr, lo, pos - 1,
                x)
    }
    return -1
}