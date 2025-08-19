package string


/**
 * This method implements a simple anagram verifier algorithm
 *
 * @param string The string to be compared with
 * @param ignoreWhitespace true if whitespaces should be ignored
 * @param ignoreCase true if casing should be ignored
 *
 * Worst-case performance       O(n)
 * Best-case performance        O(n)
 * Average performance	        O(n)
 * Worst-case space complexity	O(N)
 **/
fun String.isAnagramOf(string: String, ignoreWhitespace: Boolean = true, ignoreCase: Boolean = true): Boolean {
    val string1 = this.normalize(ignoreWhitespace, ignoreCase)
    val string2 = string.normalize(ignoreWhitespace, ignoreCase)

    if (string1.length != string2.length)
        return false

    val charMap1 = string1.toCharCountMap()
    val charMap2 = string2.toCharCountMap()

    return charMap1 == charMap2
}

private fun String.toCharCountMap(): Map<Char, Int> {
    val charMap = mutableMapOf<Char, Int>()

    this.forEach {
        val count = charMap[it] ?: 0
        charMap[it] = count + 1
    }

    return charMap
}

private fun Sequence<Char>.removeWhitespaces() = this.filter { it.isWhitespace().not() }

private fun Sequence<Char>.toLowerCase() = this.map { it.toLowerCase() }

private fun String.normalize(ignoreWhitespace: Boolean, ignoreCase: Boolean) = this
    .asSequence()
    .let { if (ignoreCase) it.toLowerCase() else it }
    .let { if (ignoreWhitespace) it.removeWhitespaces() else it }
    .joinToString("")
