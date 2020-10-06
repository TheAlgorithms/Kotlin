@file:Suppress("DuplicatedCode")

package compression

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.log2

fun Float.isInteger() = this % 1 == 0.0f

/**
 * One of the several implementations of Lempel–Ziv–Welch compression algorithm
 * https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch
 */

fun compressDataLzw(data: IntArray): List<List<Int>> {
    var lexicon = HashMap<List<Int>, List<Int>>(data.size / 2)
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)
    val lexiconKeys = LinkedList(listOf(listOf(0), listOf(1)))

    val result = ArrayList<List<Int>>(data.size)
    val current = ArrayList<Int>(20)

    var index = lexicon.size

    for (bit in data) {
        current.add(bit)
        val lastMatch = lexicon[current] ?: continue
        result.add(lastMatch)

        // add key to lexicon
        val lastKey = lexiconKeys.last
        lexicon.remove(lastKey)
        lexicon[current + 0] = lastMatch
        if (log2(index.toFloat()).isInteger()) {
            lexicon = lexicon.mapValuesTo(HashMap(lexicon.size * 2)) { (_, value) -> listOf(0) + value }
        }
        lexicon[current + 1] = Integer.toBinaryString(index).toList().map { it.toInt() }

        index++
        current.clear()
    }

    while (current.isNotEmpty() && current !in lexicon) {
        current.add(0)
    }

    if (current.isNotEmpty()) {
        val lastMatch = lexicon.getValue(current)
        result.add(lastMatch)
    }

    return result
}

fun decompressDataLzw(data: IntArray): List<List<Int>> {
    var lexicon = HashMap<List<Int>, List<Int>>(data.size / 2)
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)

    val result = ArrayList<List<Int>>(data.size)
    val current = ArrayList<Int>(20)

    var index = lexicon.size

    for (bit in data) {
        current.add(bit)
        val lastMatch = lexicon[current] ?: continue
        result.add(lastMatch)

        lexicon[current] = lastMatch + 0

        if (log2(index.toFloat()).isInteger()) {
            lexicon = lexicon.mapKeysTo(HashMap(lexicon.size * 2)) { (key, _) -> listOf(0) + key }
        }
        lexicon[Integer.toBinaryString(index).toList().map { it.toInt() }] = lastMatch + 1
        index++
        current.clear()
    }
    return result
}

