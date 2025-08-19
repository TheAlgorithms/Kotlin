/**
 * This calculates C(n,k).
 */
 
 
package io.uuddlrlrba.ktalgs.math


fun binomialfunc(n: Int, k: Int): Long {
    var j = n - k + 1
    var binomial = 1L
    for (i in 1 until k + 1) {
        binomial = binomial * j / i
        j++
    }
    return binomial
}
