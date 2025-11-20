package binaryTree

/**
 * This is the preorder traverse of binary tree
 * @param root - root of TreeNode
 * @see TreeNode - node has reference on left and right child
 */


fun preorderTraverse(root: TreeNode?): List<Int> {
    root ?: return emptyList()
    val nodes = mutableListOf<Int>()

    fun dfs(root: TreeNode?) {
        root ?: return

        nodes.add(root.value)
        dfs(root.left)
        dfs(root.right)
    }
    dfs(root)

    return nodes
}