package search

/**
 * Interpolation search is an algorithm which finds the position of a target value within an array (Sorted)
 *
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 * Average performance	O(log(log(n))) only when there is a uniform distribution of the data
 */

/**
 * @param sortedArray is an array where the element should be found. It **MUST be sorted** otherwise behavior is unpredictable.
 * @param searchedElement is an element which should be found
 * @return index of the element
 */
fun interpolationSearch(sortedArray: IntArray, searchedElement: Int): Int {
    var leftIndex = 0
    var rightIndex = sortedArray.size - 1

    while (leftIndex <= rightIndex) {
        // avoid divided by 0 during interpolation
        if (sortedArray[leftIndex] == sortedArray[rightIndex]) {
            if (sortedArray[leftIndex] == searchedElement)
                return leftIndex
            return -1
        }

        val leftValue = sortedArray[leftIndex]
        val rightValue = sortedArray[rightIndex]
        val nextIndex = leftIndex + (searchedElement - leftIndex) * (rightIndex - leftIndex) / (rightValue - leftValue)

        // out of range check
        if (nextIndex < 0 || nextIndex >= sortedArray.size)
            return -1
        val currentElement = sortedArray[nextIndex]
        if (currentElement == searchedElement)
            return nextIndex
        else {
            if (nextIndex < leftIndex) {
                rightIndex = leftIndex
                leftIndex = nextIndex
            } else if (nextIndex > rightIndex) {
                leftIndex = rightIndex
                rightIndex = nextIndex
            } else {
                if (searchedElement < currentElement)
                    rightIndex = nextIndex - 1
                else
                    leftIndex = nextIndex + 1
            }
        }
    }

    return -1
}
