package datastructures.queues
import org.assertj.core.api.Assertions.assertThat
import datastructures.Queue

import org.junit.Test

internal class QueueTest {

    @Test
    fun `#enqueue must return true queue is not full`() {
        val valueToInsert = 1

        val newQueue = Queue(10)
        val returnedValue = newQueue.enqueue(valueToInsert)

        assertThat(returnedValue).isTrue()
    }

    @Test
    fun `#enqueue must return false queue is full`() {
        val valueToInsert = 20
        val queueSize = 4
        val newQueue = Queue(queueSize)

        for(i in 0 until queueSize + 1) {
            newQueue.enqueue(i)
        }

        val returnedValue = newQueue.enqueue(valueToInsert)

        assertThat(returnedValue).isFalse()
    }

    @Test
    fun `#dequeue must return null when queue is empty`() {
        val queueSize = 2
        val newQueue = Queue(queueSize)

        val returnedValue = newQueue.dequeue()

        assertThat(returnedValue).isNull()
    }

    @Test
    fun `#dequeue must return a value when queue is not empty`() {
        val valueToInsert = 20
        val queueSize = 4
        val newQueue = Queue(queueSize)

        for(i in 0 until queueSize + 1) {
            newQueue.enqueue(i)
        }

        val returnedValue = newQueue.dequeue()

        assertThat(returnedValue).isNotNull()
        assertThat(returnedValue).isEqualTo(0)
    }
}