package ciphers

import org.junit.Test
import org.junit.Assert.*

class CaesarCipherTest {
    private val veniVidiVici = "Veni, vidi, vici"
    private val veniVidiViciRot13 = "Irav, ivqv, ivpv"
    private val veniVidiViciRot8 = "Dmvq, dqlq, dqkq"

    @Test
    fun testCaesarCipherRot13() {
        val ciphered = caesarCipher(veniVidiVici, 13)
        assertEquals(veniVidiViciRot13, ciphered)
    }

    @Test
    fun testCaesarCipherRot13Decrypt() {
       val deciphered = caesarCipher(veniVidiViciRot13, 13)
        assertEquals(veniVidiVici, deciphered)
    }

    @Test
    fun testCaesarCipherRot8() {
        val ciphered = caesarCipher(veniVidiVici, 8)
        assertEquals(veniVidiViciRot8, ciphered)
    }

    @Test
    fun testCaesarCipherRot8Decrypt() {
        val deciphered = caesarCipher(veniVidiViciRot8, 18)
        assertEquals(veniVidiVici, deciphered)
    }

    @Test
    fun testCesarCipherRot0() {
        val ciphered = caesarCipher(veniVidiVici, 0)
        assertEquals(veniVidiVici, ciphered)
    }

    @Test
    fun testCesarCipherRot26() {
        val ciphered = caesarCipher(veniVidiVici, 26)
        assertEquals(veniVidiVici, ciphered)
    }
}
