package ciphers

import org.junit.Test
import org.junit.Assert.*

class VigenereCipherTest {
    val key = "abcdefghijk"
    val equalLengthPlainText = "Lorem Ipsum"
    val equalLengthCipherText = "Lpthq Nvzcv"
    val longPlainText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam"
    val longCipherText = "Lpthq nvzcv nomqu wnz hund, cppviykaca caekswhouo nviut, vii jpiv xoowpc joyuxn tfossw oudrnuov xx qgiwao eu frptxl ujqnb comvafiv"

    @Test
    fun vigenereCipherEqualLengthEncrypt() {
        val ciphered = vigenereCipherEncrypt(equalLengthPlainText, key)
        assertEquals(equalLengthCipherText, ciphered)
    }

    @Test
    fun vigenereCipherEqualLengthDecrypt() {
        val deciphered = vigenereCipherDecrypt(equalLengthCipherText, key)
        assertEquals(equalLengthPlainText, deciphered)
    }

    @Test
    fun vigenereCipherLongEncrypt() {
        val ciphered = vigenereCipherEncrypt(longPlainText, key)
        assertEquals(longCipherText, ciphered)
    }

    @Test
    fun vigenereCipherLongDecrypt() {
        val deciphered = vigenereCipherDecrypt(longCipherText, key)
        assertEquals(longPlainText, deciphered)
    }

    @Test
    fun vigenereCipherUppercaseKeyEncrypt() {
        val ciphered = vigenereCipherEncrypt(longPlainText, key.toUpperCase())
        assertEquals(longCipherText, ciphered)
    }

    @Test
    fun vigenereCipherAKeyEncrypt() {
        val ciphered = vigenereCipherEncrypt(longPlainText, "aaaa")
        assertEquals(longPlainText, ciphered)
    }
}
