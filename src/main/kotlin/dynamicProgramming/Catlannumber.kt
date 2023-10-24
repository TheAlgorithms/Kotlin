package dynamicProgramming
class kushal {
    // A dynamic programming based function to find nth Catalan number
    companion object {
        fun catalanDP(n: Int): Int {
            // Table to store results of subproblems
            val catalan = IntArray(n + 2)

            // Initialize first two values in table
            catalan[0] = 1
            catalan[1] = 1

            // Fill entries in catalan[]
            // using recursive formula
            for (i in 2..n) {
                catalan[i] = 0
                for (j in 0 until i) {
                    catalan[i] += catalan[j] * catalan[i - j - 1]
                }
            }

            // Return last entry
            return catalan[n]
        }
    }

    // Driver code
    fun main(args: Array<String>) {
        for (i in 0 until 10) {
            print("${catalanDP(i)} ")
        }
    }
}

fun main() {
    GFG().main(emptyArray())
}
