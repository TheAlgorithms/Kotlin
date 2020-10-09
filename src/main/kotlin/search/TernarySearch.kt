package search

fun ternarySearch(l: Double, r: Double, func: (Double) -> Double, eps: Double = 1e-3): Double {
    var left = l
    var right = r
    while (right - left > eps) {
        val midFirst = left + (right - left) / 3
        val midSecond = right - (right - left) / 3
        if (func(midFirst) < func(midSecond)) {
            left = midFirst
        } else {
            right = midSecond
        }
    }
    return left
}