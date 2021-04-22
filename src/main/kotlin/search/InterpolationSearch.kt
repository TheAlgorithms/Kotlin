package search

/**
 * Searches for key in the sorted array
 * @param array a sorted array in which key should be searches
 * @param key the element which should be searched in array
 * @return the index of key in or -1 if key is not contained in array
 */
fun interpolationSearch(array: Array<Int>, key: Int, startIndex: Int = 0, endIndex: Int = array.size-1): Int {
    if (startIndex >= endIndex) {
        return -1
    }
    val pos = startIndex + (key-array[startIndex]) * (endIndex-startIndex) / (array[endIndex]-array[startIndex])
    if (array[pos] == key) {
        return pos
    } else if (array[pos] > key) {
        return interpolationSearch(array, key, startIndex, pos-1)
    } else {
        return interpolationSearch(array, key, pos+1, endIndex)
    }
}

