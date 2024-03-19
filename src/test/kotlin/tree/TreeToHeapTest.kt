package tree

import org.junit.Assert
import org.junit.Test
import kotlin.random.Random
import tree.HeapToTree.heapToTree
import tree.TreeToHeap.transformToHeap

class TreeToHeapTest {

    @Test
    fun treeToHeapTest() {
        val array = Array<Int?>( Random.nextInt( 100 ) ) { null }
        for ( i in array.indices) array[i] = Random.nextInt()
        val transformed = heapToTree( array )
                            .transformToHeap
        Assert.assertArrayEquals( array , transformed )
    }

}