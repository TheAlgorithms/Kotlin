import java.util.Arrays
fun pigeonhole_sort(arr: IntArray, n: Int):IntArray {
    var min = arr[0]
    var max = arr[0]
    val range: Int
    var i: Int
    var j: Int
    var index: Int

    for (a in 0 until n) {
        if (arr[a] > max)
            max = arr[a]
        if (arr[a] < min)
            min = arr[a]
    }

    range = max - min + 1
    val phole = IntArray(range)
    Arrays.fill(phole, 0)

    i = 0
    while (i < n) {
        phole[arr[i] - min]++
        i++
    }


    index = 0

    j = 0
    while (j < range) {
        while (phole[j]-- > 0)
            arr[index++] = j + min
        j++
    }
    return arr

}

fun main(args: Array<String>) {
    val l = intArrayOf(-18,-2,12,23,4,2,6,1,0,-7,77)
    println(pigeonhole_sort(l, l.size).contentToString())
}
