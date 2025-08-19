@file:Suppress("DuplicatedCode")

package compression

import java.io.InputStream
import java.io.OutputStream
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.log2

fun Int.toBitList(): List<Int> {
    var index = Int.SIZE_BITS - Integer.numberOfLeadingZeros(this)
    val list = ArrayList<Int>(index)
    while (index > 0)
        list.add((this shr --index) and 1)
    return list
}

fun Float.isInteger() = this % 1 == 0.0f

/**
 * Compress an array of bits
 *
 * One of the several implementations of Lempel–Ziv–Welch compression algorithm
 * https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch
 * Based on the Python version
 * https://github.com/TheAlgorithms/Python/blob/master/compression/lempel_ziv.py
 *
 * @param inputStream binary input stream from which we can read bit by bit
 * @param outputStream binary output stream to which we can write bit by bit
 */

fun compressLzw(inputStream: BitInputStream, outputStream: BitOutputStream) {
    var lexicon = HashMap<List<Int>, List<Int>>()
    // Original bits
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)

    val current = ArrayList<Int>(20)

    var index = lexicon.size

    var bit = inputStream.read()
    while (bit != -1) {
        current.add(bit)
        bit = inputStream.read()

        /*
         * When we found current bit array in lexicon, we add current to lexicon and
         * we add (current + 0) and (current + 1) to lexicon
         */
        val match = lexicon[current] ?: continue
        outputStream.write(match)

        lexicon.remove(current)
        lexicon[current + 0] = match

        /*
         * If log2(index) is integer we need bigger number to store index
         * index < 2 -> two values can be stored
         * 2 <= index < 4 -> 4 values can be stored
         * When we increase the size to store index, we add 0 before each other
         */
        if (log2(index.toFloat()).isInteger()) {
            // Add one zero before each other values to make it possible to have more index value
            lexicon = lexicon.mapValuesTo(HashMap(lexicon.size)) { (_, value) -> listOf(0) + value }
        }

        lexicon[current + 1] = index.toBitList()

        index++
        current.clear()
    }

    while (current.isNotEmpty() && current !in lexicon) {
        current.add(0)
    }

    if (current.isNotEmpty()) {
        val match = lexicon.getValue(current)
        outputStream.write(match)
    }

    outputStream.flush()
}

/**
 * Decompress an array of bit compressed with {@link compressDataLzw}
 *
 * @param inputStream binary input stream from which we can read bit by bit
 * @param outputStream binary output stream to which we can write bit by bit
 */
fun decompressLzw(inputStream: BitInputStream, outputStream: BitOutputStream) {
    var lexicon = HashMap<List<Int>, List<Int>>()
    lexicon[listOf(0)] = listOf(0)
    lexicon[listOf(1)] = listOf(1)

    val current = ArrayList<Int>(20)

    var index = lexicon.size

    var bit = inputStream.read()
    while (bit != -1) {
        current.add(bit)
        bit = inputStream.read()

        val match = lexicon[current] ?: continue
        outputStream.write(match)

        lexicon[current] = match + 0

        if (log2(index.toFloat()).isInteger()) {
            lexicon = lexicon.mapKeysTo(HashMap(lexicon.size)) { (key, _) -> listOf(0) + key }
        }

        lexicon[index.toBitList()] = match + 1

        index++
        current.clear()
    }

    outputStream.discardByteIfZero()
    outputStream.flush()
}

/**
 * Read InputStream bit by bit
 */
class BitInputStream(private val inputStream: InputStream) : InputStream() {
    private var index = 7
    private var byte = inputStream.read()

    override fun close() {
        inputStream.close()
    }

    override fun read(): Int {
        if (index < 0) {
            index = 7
            byte = inputStream.read()
            if (byte == -1)
                return -1
        }
        val bit = (byte shr index) and 1
        index--
        return bit
    }
}

/**
 * Write to OutputStream bit by bit
 */
class BitOutputStream(private val outputStream: OutputStream) : OutputStream() {
    private var index = 7
    private var byte: Int = 0

    override fun close() {
        flush()
        outputStream.close()
    }

    override fun flush() {
        if (index < 7)
            outputStream.write(byte)
        super.flush()
        outputStream.flush()
    }

    override fun write(bit: Int) {
        if (index < 0) {
            index = 7
            outputStream.write(byte)
            byte = 0
        }
        byte = byte or (bit shl index)
        index--
    }

    /**
     * Remove trailing zeros if last byte is not complete
     */
    fun discardByteIfZero(): Boolean {
        if (byte == 0) {
            index = 7
            byte = 0
            return true
        }
        return false
    }

    fun write(bits: List<Int>) = bits.forEach { write(it) }

}

