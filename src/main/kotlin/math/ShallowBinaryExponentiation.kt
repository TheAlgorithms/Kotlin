package math

import java.math.BigInteger

const val ERROR_MESSAGE_FOR_NEGATIVE_INDICES = "Binary Exponentiation cannot be used for negative indices"

internal inline fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)

internal fun throwIllegalArgumentExceptionForNegativeIndices(): Nothing =
    throw IllegalArgumentException(ERROR_MESSAGE_FOR_NEGATIVE_INDICES)

/**
 * Calculates a.pow(b) by using the algorithm of binary exponentiation,
 * @param that allows for arbitrarily large indices.
 * However, sufficiently large indices (as a rule of thumb : anything above 2 ^ 1000 as index) can cause a stack-overflow
 * To prevent stack overflow and use arbitrarily large indices, use deep recursive binary exponentiation
 * */
infix fun BigInteger.bpow(that: BigInteger): BigInteger {
    if (that < BigInteger.ZERO) {
        throwIllegalArgumentExceptionForNegativeIndices()
    }
    if (that == BigInteger.ZERO) {
        return BigInteger.ONE
    }
    val toSquare = this.bpow(that / 2.toBigInteger())
    return if (that % 2.toBigInteger() == BigInteger.ZERO) {
        toSquare * toSquare
    } else {
        this * toSquare * toSquare
    }
}

/**
 * Calculates a.pow(b) by using the algorithm of binary exponentiation,
 * where a is the base and b is the index.
 * If b is odd, a.pow(b) is written as a * (a.pow(b / 2)).
 * If b is even, a.pow(b) is written as (a.pow(b / 2)).
 * We compute (a.pow(b / 2)) recursively.
 * Time  Complexity : O(log(n)).
 * Space Complexity : O(1).
 * @see Long.bpow
 * @see BigInteger.bpow
 * @receiver the base of exponentiation
 * @param that : the index of exponentiation
 */
infix fun Int.bpow(that: Int): Int {
    if (that < 0) {
        throwIllegalArgumentExceptionForNegativeIndices()
    }
    // a.pow(0) = 1
    if (that == 0) {
        return 1
    }

    val toSquare = this.bpow(that / 2)
    return if (that % 2 == 0) {
        toSquare * toSquare
    } else {
        this * toSquare * toSquare
    }
}

/**
 * Calculates a.pow(b) by using the algorithm of binary exponentiation
 * Note that neither the [Int.bpow] nor [Long.bpow] are overflow-proof,
 * they use native ints (32-bit signed integers) and longs (64-bit signed integers).
 * To use overflow-proof exponentiation, use [BigInteger.bpow]
 * @see Int.bpow(that)
 * @see BigInteger.bpow
 * @receiver the base of exponentiation
 * @param that : the index of exponentiation
 * */
infix fun Long.bpow(that: Long): Long {
    if (that < 0L) {
        throwIllegalArgumentExceptionForNegativeIndices()
    }
    if (that == 0L) {
        return 1L
    }
    val toSquare = this.bpow(that / 2)
    return if (that % 2L == 0L) {
        toSquare * toSquare
    } else {
        this * toSquare * toSquare
    }
}

