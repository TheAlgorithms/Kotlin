package datastructures.buffers

import kotlin.IllegalArgumentException
import kotlin.IllegalStateException

class CircularBuffer(private val bufferSize: Int) {
    private var buffer: Array<Char>
    private var writeIndex = 0
    private var readIndex = 0
    private var readableData = 0

    init {
        if (!isPowerOfTwo(bufferSize)) {
            throw IllegalArgumentException()
        }
        buffer = Array(bufferSize) { 0.toChar() }
    }

    fun readOutChar(): Char {
        if (readableData <= 0) {
            throw IllegalStateException("Cannot read from empty buffer")
        }
        val result = buffer[getTrueIndex(readIndex)]
        readableData--
        readIndex++
        return result
    }

    fun writeToCharBuffer(c: Char) {
        if (readableData >= bufferSize) {
            throw IllegalStateException("Cannot write to full buffer")
        }
        buffer[getTrueIndex(writeIndex)] = c
        readableData++
        writeIndex++
    }

    private fun isPowerOfTwo(number: Int) = (number and (number - 1)) == 0

    private fun getTrueIndex(index: Int) = index % bufferSize

    fun size() = readableData
}

fun main() {
    val buff = CircularBuffer(1024)

    buff.writeToCharBuffer('f')
    buff.writeToCharBuffer('o')

    println(buff.readOutChar())
    println(buff.readOutChar())
}