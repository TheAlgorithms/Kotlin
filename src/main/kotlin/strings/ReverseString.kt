package strings

/**
 * Reverses a given string in-place.
 *
 * @param str The input string to be reversed.
 * @return The reversed string.
 */
fun reverseString(str: String): String {
    // Check if the input string is null or empty.
    if (str.isNullOrEmpty()) {
        // If it is, return the input string as it is (no change needed).
        return str
    }

    // Convert the input string to a character array.
    val charArray = str.toCharArray()
    var i = 0
    var j = str.length - 1

    // Swap characters from the beginning and end to reverse the string in-place.
    while (i < j) {
        val temp = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = temp
        i++
        j--
    }

    // Convert the character array back to a string and return the reversed string.
    return String(charArray)
}
