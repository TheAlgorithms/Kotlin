/**
 * Computes the number of combinations (n choose r)
 */
fun nCr(n: Int, r: Int): Long {
    require(n >= 0 && r >= 0 && r <= n) { "Invalid n or r" }
    var result = 1L
    for (i in 1..r) {
        result = result * (n - i + 1) / i
    }
    return result
}

fun main() {
    println("C(5,2) = ${nCr(5,2)}")  // 10
    println("C(10,3) = ${nCr(10,3)}") // 120
    println("C(6,0) = ${nCr(6,0)}")  // 1
}
