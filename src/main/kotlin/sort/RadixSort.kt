package sort

fun radixSort(array: Array<Int>, n: Int) {
    val m = getMax(array, n)

    var exp = 1
    while (m / exp > 0) {
        countSort(array, n, exp)
        exp *= 10
    }
}

private fun countSort(array: Array<Int>, n: Int, exp: Int) {
    val output: MutableList<Int?> = mutableListOf(*arrayOfNulls(n))
    val count = MutableList(10) { 0 }

    for (i in 0 until n) {
        count[(array[i].div(exp)) % 10]++
    }

    for (i in 1 until 10) {
        count[i] += count[i - 1]
    }

    var i: Int = n - 1
    while (i >= 0) {
        output[count[array[i] / exp % 10] - 1] = array[i]
        count[array[i] / exp % 10]--
        i--
    }

    for (i in 0 until n) {
        array[i] = output[i]!!
    }
}

private fun getMax(array: Array<Int>, n: Int): Int {
    var max = array[0]
    for (i in 1 until n) {
        if (array[i] > max) {
            max = array[i]
        }
    }
    return max
}
