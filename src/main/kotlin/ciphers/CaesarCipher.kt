package ciphers

/**
 * Encrypts the input string using the Caesar Ciphre
 * @param plainText the text which should be encrypted
 * @param shift the shift used
 * @return the encrypted text
 */
fun caesarCipher(plainText: String, shift: Int): String {
    assert(shift >= 0)
    return plainText.map { c ->
        caesarRotate(c, shift)
    }.joinToString("");
}

/**
 * Rotates a single Character by shift
 * @param inChar the input charackter
 * @param shift the amount to shift
 * @return the shifted charackter
 */
fun caesarRotate(inChar: Char, shift: Int): Char {
    assert(shift >= 0)
    val offset = getAlphabetOffset(inChar)
    if (offset == -1) {
        return inChar
    }
    return ((((inChar.toInt()-offset)+shift) % 26) + offset).toChar()
}

/**
 * Gets the offset of the Alphabet in the ASCII table.
 * @param inChar the charackter for witch the offset is to be determined
 * @return the offset. Is -1 if inChar is a special character -1
 */
fun getAlphabetOffset(inChar: Char): Int {
    return if (inChar in 'A'..'Z') {
        65
    } else if (inChar in 'a'..'z') {
        97
    } else {
        -1
    }
}
