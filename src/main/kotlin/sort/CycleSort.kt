package sort

/**
 * This method implements the Cycle sort
 *
 * @param array The array to be sorted
 * Cycle sort is an in-place, unstable sorting algorithm, a comparison sort that is theoretically optimal in terms of the
 * total number of writes to the original array, unlike any other in-place sorting algorithm.
 *
 * Worst-case performance	    O(n^2)
 * Best-case performance	    Ω(n^2)
 * Average performance      	Θ(n^2)
 * Worst-case space complexity	Θ(n) total, Θ(1) auxiliary
 **/
fun <T: Comparable<T>> cycleSort(array: Array<T>) {
    var w = 0 // count number of memory writes
    val arrayLength = array.size

    for (start in 0..arrayLength - 2) {
        var item = array[start] // initializing the starting point

        var position = start // find the position where we put the item
        for (i in start + 1 until arrayLength)
            if (array[i] < item)
                position++

        if (position == start)
        // if the item is already in the correct position
            continue

        while (item == array[position])
        // ignore all duplicate elements
            position += 1

        if (position != start) { // put the item to it's right position
            val temp = item
            item = array[position]
            array[position] = temp
            w++
        }

        while (position != start) { // rotate rest of the cycle
            position = start

            for (i in start + 1 until arrayLength)
                if (array[i] < item)
                    position += 1

            while (item == array[position])
                position += 1

            if (item != array[position]) {
                val temp = item
                item = array[position]
                array[position] = temp
                w++
            }
        }
    }
}