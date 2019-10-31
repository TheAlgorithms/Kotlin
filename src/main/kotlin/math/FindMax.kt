package math

/**
 * find max of array
 *
 * @param intArr the int array contains element
 * @return max value
 */
fun findMax(intArr: IntArray) : Int {
    var max = intArr[0]
    for (i in intArr.indices) {
        if (intArr[i] > max) max = intArr[i]
    }

    return max
}