@file:Suppress("DuplicatedCode")

package compression

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.log2

typealias Bit = Int

fun Float.isInteger() = this % 1 == 0.0f

fun Int.getBitAt(position: Int): Bit = (this shr position) and 1

fun ByteArray.toBitArray(): Array<Int> {
    val result = Array(size * 8) { -1 }
    var index = 0
    for (byte in this) {
        for (i in 7 downTo 0) {
            result[index++] = byte.toInt().getBitAt(i)
        }
    }
    return result
}

/**
 * One of the several implementations of Lempel–Ziv–Welch compression algorithm
 * https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch
 */

fun compressDataLzw(data: Array<Bit>): Array<Bit> {
    var lexicon = HashMap<List<Bit>, List<Bit>>(data.size / 2)
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)

    val result = ArrayList<List<Bit>>(data.size)
    val current = ArrayList<Bit>(20)

    var index = lexicon.size

    for (bit in data) {
        current.add(bit)
        val lastMatch = lexicon[current] ?: continue
        result.add(lastMatch)

        // add key to lexicon
        lexicon.remove(current)
        lexicon[current + 0] = lastMatch
        if (log2(index.toFloat()).isInteger()) {
            // Add one zero before each other values to make it possible to have more index value
            lexicon = lexicon.mapValuesTo(HashMap(lexicon.size * 2)) { (_, value) -> listOf(0) + value }
        }
        val temp = Integer.toBinaryString(index).toList().map { it.toInt() - '0'.toInt() }
        lexicon[current + 1] = temp

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

    return result.flatten().toTypedArray()
}

fun decompressDataLzw(data: Array<Bit>): Array<Bit> {
    var lexicon = HashMap<List<Bit>, List<Bit>>(data.size / 2)
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)

    val result = ArrayList<List<Bit>>(data.size)
    val current = ArrayList<Bit>(20)

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
    return result.flatten().toTypedArray()
}

