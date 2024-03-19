package tree

import org.junit.Assert
import org.junit.Test
import tree.HeapToTree.heapToTree

class HeapToTreeTest {

    private fun check( custom : TreeNode? , generated : TreeNode? ) : Boolean {
        if ( custom == null && generated == null ) return true
        if ( custom == null || generated == null ) return false
        val current = custom.`val` == generated.`val`
        val left = check( custom.left , generated.left )
        val right = check( custom.right , generated.right )
        return current && left && right
    }

    @Test
    fun testForGeneratedTree() {
        val custom = TreeNode( 1 ).apply {
            left = TreeNode( 2 )
            right = TreeNode( 3 )
        }
        val generated = heapToTree( 1 , 2 , 3 )
        Assert.assertTrue( check( custom , generated ) )
    }

}