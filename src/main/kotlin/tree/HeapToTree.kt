package tree

object HeapToTree {

    fun heapToTree( heap : Array<Int?> , index : Int = 0 ) : TreeNode? = when {
        index >= heap.size || heap[index] == null -> null
        else -> TreeNode( heap[index]!! ).apply {
            left = heapToTree( heap , (index*2)+1 )
            right = heapToTree( heap , (index*2)+2 )
        }
    }

    fun heapToTree( vararg nodes : Int? ) : TreeNode? = heapToTree( arrayOf( *nodes ) )

}