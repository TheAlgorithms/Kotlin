package dataStructures.heap

/**
 * Binary heap (or MinHeap/MaxHeap) stores its values in the binary tree
 * and keeps its smallest (largest) value on top of this tree.
 * The binary tree must meet the following criteria:
 * - It is a complete binary tree.
 * - The value of each node must be no greater than (or no less than) the value of its child nodes.
 *
 * Binary heap is used as a data structure inside the Priority Queue that allows
 * both inserting and removing elements in O(logN) time.
 *
 * The complete binary tree can be implemented using the array.
 * The top of the tree is in the first element.
 * Children of any node can be calculated by formulas i * 2 + 1 and i * 2 + 2.
 * Parent node index calculates by formula (i - 1) / 2.
 *
 * Links to useful articles about binary heap:
 * Wikipedia: https://en.wikipedia.org/wiki/Binary_heap
 * Basic implementation: https://www.geeksforgeeks.org/binary-heap/
 * Heapify logic and complexity: https://www.geeksforgeeks.org/building-heap-from-array/
 * Leetcode learning card: https://leetcode.com/explore/learn/card/heap
 */

/**
 * @param array is the initial array of unsorted values.
 * @param comparator defines the sorting order. For minHeap use the default Comparator.naturalOrder()
 * comparator. For maxHeap, use Comparator.reverseOrder().
 */
class BinaryHeap<T: Comparable<T>>(
    array: Collection<T> = emptyList(),
    private val comparator: Comparator<T> = Comparator.naturalOrder()
) {
    private val list = mutableListOf<T>()

    init {
        list.addAll(0, array)
        list.heapify()
    }

    val size get() = list.size

    /**
     * Returns the min/max element if the heap is not empty without removing the element.
     * Time complexity: O(1)
     */
    fun peek(): T? = if (list.any()) list[0] else null

    /**
     * Adds a new element into the heap.
     * Time complexity: O(logN)
     */
    fun push(item: T) {
        list.add(item)
        list.bubbleUp(size-1)
    }

    /**
     * Removes the min/max element from the heap and returns it.
     * Time complexity: O(logN)
     */
    fun pop(): T? {
        return (if (list.any()) list[0] else null)?.also {
            list.swap(0, size - 1)
            list.removeLast()
            list.sinkDown(0)
        }
    }

    private fun MutableList<T>.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }

    private fun MutableList<T>.bubbleUp(idx: Int) {
        var cur = idx
        var parent = (cur - 1) / 2
        while(cur > 0 && this[cur] isSmallerThan this[parent]) {
            this.swap(cur, parent)
            cur = parent
            parent = (cur - 1) / 2
        }
    }

    private fun MutableList<T>.sinkDown(idx: Int) {
        var cur = idx
        var leftChild = cur * 2 + 1
        while (leftChild < size) {
            val rightChild = leftChild + 1
            val minChild =
                if (rightChild < size && list[rightChild] isSmallerThan  list[leftChild])
                    rightChild
                else leftChild

            if (list[cur] isSmallerThan list[minChild]) return

            list.swap(cur, minChild)
            cur = minChild
            leftChild = cur * 2 + 1
        }
    }

    /**
     * Heapify the initial unordered array.
     * Time complexity: O(N) - significantly faster than adding elements one by one: O(logN).
     */
    private fun MutableList<T>.heapify() =
        (size/2-1 downTo 0)
            .forEach { i -> this.sinkDown(i) }

    private infix fun T.isSmallerThan(that: T) =
        comparator.compare(this, that) < 0
}