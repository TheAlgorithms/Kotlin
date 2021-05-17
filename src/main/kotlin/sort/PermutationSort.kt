package sort

fun <T : Comparable<T>> isSorted(list: List<T>): Boolean {
    val size = list.size
    if (size < 2) return true
    for (i in 1 until size) {
        if (list[i] < list[i - 1]) return false
    }
    return true
}
 
fun <T : Comparable<T>> permute(input: List<T>): List<List<T>> {
    if (input.size == 1) return listOf(input)
    val perms = mutableListOf<List<T>>()
    val toInsert = input[0]
    for (perm in permute(input.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, toInsert)
            perms.add(newPerm)
        }
    }
    return perms
}
 
fun <T : Comparable<T>> permutationSort(input: List<T>): List<T> {
    if (input.size == 1) return input
    val toInsert = input[0]
    for (perm in permute(input.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, toInsert)
            if (isSorted(newPerm)) return newPerm
        }
    }
    return input
}
 
