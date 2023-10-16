package strings

/**
 * Reverses a given string
 *
 * @param str The input string to be reversed.
 * @return The reversed string.
 */
fun reverseString(str: String): String {
    if (str.isNullOrEmpty()) {
        return str
    }

    val charArray = str.toCharArray()
    var i = 0
    var j = str.length - 1

    while (i < j) {
        val temp = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = temp
        i++
        j--
    }

    return String(charArray)
}
