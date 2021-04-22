package ciphers

/**
 * Encrypts the input string using the Vigenère cipher
 * @param plainText the text which should be encrypted
 * @param key the key which is used to encrypt the input text (only the characters a-z and A-Z are allowed)
 * @return the encrypted text
 */
fun vigenereCipherEncrypt(plainText: String, key: String): String
        = vigenereCipher(plainText, key, false)

/**
 * Decrypts an input string encrypted using the Vigenère cipher
 * @param cipherText the text which should be decrypted
 * @param key the key which is used to encrypt the input text (only the characters a-z and A-Z are allowed)
 * @return the decrypted text
 */
fun vigenereCipherDecrypt(cipherText: String, key: String): String
        = vigenereCipher(cipherText, key, true)

/**
 * Applies the Vigenère cipher to the input text
 * @param inputText the input text to which the Vigenère cipher is applied
 * @param key the key which is used to encrypt the input text (only the characters a-z and A-Z are allowed)
 * @param decrypt when false the input text is Vigenère encrypted. When true the input text is Vigenère decrypted
 * @return the text on which the Vigenère cipher has been applied
 */
private fun vigenereCipher(inputText: String, key: String, decrypt: Boolean): String {
    var i = 0
    return inputText.map { c ->
        if (getAlphabetOffset(c) == -1) {
            return@map c
        }
        var shift = vigenereGetShiftAtIndex(key, i++)
        if (decrypt) {
            shift = 26 - shift
        }
        caesarRotate(c, shift)
    }.joinToString("");
}

/**
 * @param key only the characters a-z and A-Z are allowed
 * @param index the index for which the shift index is to be determined
 * @return a shift index which can be used in cesar rotation
 */
private fun vigenereGetShiftAtIndex(key: String, index: Int): Int {
    val keyChar = key[index % key.length]
    val offset = getAlphabetOffset(keyChar)
    assert(offset != -1) {"$keyChar is not allowed in a vigenere key"}
    return keyChar.toInt()-offset
}
