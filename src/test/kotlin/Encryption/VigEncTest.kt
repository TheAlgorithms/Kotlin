import org.junit.Test
import java.util.*

class VigEncTest {
    @Test
    fun testWithAttackAtDawnString() {
        val secretText = "ATTACKATDAWN"
        val key = "LEMON"
        val encoded = vigenere(secretText, key)
        assert(vigenere(encoded, key, false)==secretText)

    }
    @Test
    fun testWithIntellIjString() {
        val secretText = "INTELLIJJIDEA"
        val key = "CIPHER"
        val encoded = vigenere(secretText, key)
        assert(vigenere(encoded, key, false)==secretText)

    }
    @Test
    fun testWithAlgorithmjString() {
        val secretText = "ALGORITHMREPO"
        val key = "LEMON"
        val encoded = vigenere(secretText, key)
        assert(vigenere(encoded, key, false)==secretText)

    }
}
