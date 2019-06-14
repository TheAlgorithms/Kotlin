package datastructures.buffers

import org.junit.Assert.assertEquals
import org.junit.Test

class CircularBufferTest {

    @Test
    fun testNormalUsage() {
        val buffer = CircularBuffer<Char>(4)

        buffer.add('a')
        buffer.add('b')
        buffer.add('c')

        assertEquals('a', buffer.poll())
        assertEquals('b', buffer.poll())
        assertEquals('c', buffer.poll())
    }

    @Test
    fun testSizeReporting() {
        val buffer = CircularBuffer<Char>(4)

        buffer.add('a')
        assertEquals(1, buffer.size())
        buffer.add('b')
        assertEquals(2, buffer.size())
        buffer.add('c')
        assertEquals(3, buffer.size())

        buffer.poll()
        assertEquals(2, buffer.size())
        buffer.poll()
        assertEquals(1, buffer.size())
        buffer.poll()
        assertEquals(0, buffer.size())
    }

    @Test(expected = IllegalStateException::class)
    fun testBufferFull() {
        val buffer = CircularBuffer<Char>(2)

        buffer.add('a')
        buffer.add('b')
        buffer.add('c')

        assertEquals('a', buffer.poll())
        assertEquals('b', buffer.poll())
        assertEquals(null, buffer.poll())
    }

    @Test
    fun testBufferOverflow() {
        val buffer = CircularBuffer<Char>(2)

        buffer.add('a')
        buffer.add('b')
        assertEquals('a', buffer.poll())
        assertEquals('b', buffer.poll())

        buffer.add('c')
        assertEquals('c', buffer.poll())
    }
}