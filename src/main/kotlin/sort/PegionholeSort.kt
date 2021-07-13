import java.util.Arrays

fun pigeonholeSort(arr: IntArray, n: Int):IntArray {
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
    for(i in 0 until n) {
        phole[arr[i] - min]++
        
    }
    
    index = 0
    j = 0
    for(j in 0 until range) {
        while (phole[j]-- > 0)
        	arr[index++] = j + min     
    }

    return arr
}
