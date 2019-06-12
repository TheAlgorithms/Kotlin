package datastructures.buffers

import org.junit.Assert.assertEquals
import org.junit.Test

class CircularBufferTest {

    @Test
    fun testNormalUsage() {
        val buffer = CircularBuffer(4)

        buffer.writeToCharBuffer('a')
        buffer.writeToCharBuffer('b')
        buffer.writeToCharBuffer('c')

        assertEquals('a', buffer.readOutChar())
        assertEquals('b', buffer.readOutChar())
        assertEquals('c', buffer.readOutChar())
    }

    @Test
    fun testSizeReporting() {
        val buffer = CircularBuffer(4)

        buffer.writeToCharBuffer('a')
        assertEquals(1, buffer.size())
        buffer.writeToCharBuffer('b')
        assertEquals(2, buffer.size())
        buffer.writeToCharBuffer('c')
        assertEquals(3, buffer.size())

        buffer.readOutChar()
        assertEquals(2, buffer.size())
        buffer.readOutChar()
        assertEquals(1, buffer.size())
        buffer.readOutChar()
        assertEquals(0, buffer.size())
    }

    @Test(expected = IllegalStateException::class)
    fun testBufferFull() {
        val buffer = CircularBuffer(2)

        buffer.writeToCharBuffer('a')
        buffer.writeToCharBuffer('b')
        buffer.writeToCharBuffer('c')

        assertEquals('a', buffer.readOutChar())
        assertEquals('b', buffer.readOutChar())
        assertEquals(null, buffer.readOutChar())
    }

    @Test
    fun testBufferOverflow() {
        val buffer = CircularBuffer(2)

        buffer.writeToCharBuffer('a')
        buffer.writeToCharBuffer('b')
        assertEquals('a', buffer.readOutChar())
        assertEquals('b', buffer.readOutChar())

        buffer.writeToCharBuffer('c')
        assertEquals('c', buffer.readOutChar())
    }
}