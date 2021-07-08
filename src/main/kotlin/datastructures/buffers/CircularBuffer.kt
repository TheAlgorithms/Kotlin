package datastructures.buffers

class CircularBuffer<T>(private val bufferSize: Int) {
    private var buffer: Array<Any?>
    private var writeIndex = 0
    private var readIndex = 0
    private var readableData = 0

    init {
        if (!isPowerOfTwo(bufferSize)) {
            throw IllegalArgumentException()
        }
        buffer = arrayOfNulls<Any?>(bufferSize)
    }

    fun poll(): T {
        if (readableData <= 0) {
            throw IllegalStateException("Cannot read from empty buffer")
        }
        val result = buffer[getTrueIndex(readIndex)]
        readableData--
        readIndex++
        @Suppress("UNCHECKED_CAST")
        return result as T
    }

    fun add(element: T) {
        if (readableData >= bufferSize) {
            throw IllegalStateException("Cannot write to full buffer")
        }
        buffer[getTrueIndex(writeIndex)] = element
        readableData++
        writeIndex++
    }

    private fun isPowerOfTwo(number: Int) = (number and (number - 1)) == 0

    private fun getTrueIndex(index: Int) = index % bufferSize

    fun size() = readableData
}