package tree

object TreeToHeap {

    private fun TreeNode?.count( level : Int = 0 ) : Int = when {
        this == null -> 0
        else -> {
            var current = 1
            repeat( level ) { current *= 2 }
            val left = left.count( level+1 )
            val right = right.count( level+1 )
            current + if ( left > right ) left else right
        }
    }

    private fun TreeNode?.recursiveAdd( heap : Array<Int?> , index : Int = 0 ) {
        this?.run {
            heap[index] = `val`
            left.recursiveAdd( heap , index*2+1 )
            right.recursiveAdd( heap , index*2+2 )
        }
    }

    private inline fun <reified T> Array<T?>.trimNullSuffix() : Array<T?> {
        var i = size-1
        while ( get( i ) == null ) i--
        i++
        val trimmedArray = Array<T?>(i){null}
        for ( j in 0 until i ) trimmedArray[j] = get(j)
        return trimmedArray
    }

    val TreeNode?.transformToHeap : Array<Int?>
        get() {
            val heap = Array<Int?>( count() ) { null }
            recursiveAdd( heap )
            return heap.trimNullSuffix()
        }

}