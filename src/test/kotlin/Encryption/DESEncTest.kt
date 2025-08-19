import org.junit.Test
import java.util.*

class DESEncTest {

    @Test
    fun testWithKotlinString() {
        val secretText = "Kotlin is a powerful programming language"
        val encryptedValue = TripleDESDemo().encrypt(secretText)
        assert(TripleDESDemo().decrypt(encryptedValue)==secretText)

    }
    @Test
    fun testWithIntellIjString() {
        val secretText = "InteliJ IDEA Community Edition"
        val encryptedValue = TripleDESDemo().encrypt(secretText)
        assert(TripleDESDemo().decrypt(encryptedValue)==secretText)

    }
    @Test
    fun testWithAlgorithmjString() {
        val secretText = "Algorithm-Repo"
        val encryptedValue = TripleDESDemo().encrypt(secretText)
        assert(TripleDESDemo().decrypt(encryptedValue)==secretText)

    }

}
