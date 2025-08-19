//CocktailSort function
 
fun cocktailSort(a: IntArray) {
    fun swap(i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }   
    do {
        var swapped = false
        for (i in 0 until a.size - 1)
            if (a[i] > a[i + 1]) {
                swap(i, i + 1)
                swapped = true
            }
        if (!swapped) break
        swapped = false
        for (i in a.size - 2 downTo 0) 
            if (a[i] > a[i + 1]) {
                swap(i, i + 1)
                swapped = true
            }
    }
    while (swapped)
}
 
fun main(args: Array<String>) {
   val aa = arrayOf(
        intArrayOf(100, 2, 56, 200, -52, 3, 99, 33, 177, -199),
        intArrayOf(4, 65, 2, -31, 0, 99, 2, 83, 782, 1),
        intArrayOf(62, 83, 18, 53, 7, 17, 95, 86, 47, 69, 25, 28)
    )
    for (a in aa) {
        cocktailSort(a)
        println(a.joinToString(", "))
    }
}
