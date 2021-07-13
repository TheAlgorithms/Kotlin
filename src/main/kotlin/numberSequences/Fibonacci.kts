package numberSequences
/**
 *@author PSigauque
 */

/** The Fibonacci sequence is a sequence of integers, usually beginning with 0 and 1,
 *  in which each subsequent term corresponds to the sum of the previous two.
 *  Fibonacci numbers are therefore the numbers that make up the following sequence:
 * 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, etc.
 *
 * In mathematical terms, the sequence is recursively defined by the formula below,
 * where the first term F1 = 1: F (n) = F (n-1) + F (n-2)
 * Initial values: F (1) = 1 and F (2).
 */

/**
 * @param n is the position of the term to be found
 * @return the term in the searched position
 */
fun fibonacci(n: Int) {
    if (n<=2) {
        return 1
    }
    else
        return fibonacci(n-1) + fibonacci(n-2)

}