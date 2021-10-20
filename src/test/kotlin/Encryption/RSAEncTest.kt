import encryption.Caesar
import org.junit.Test
import java.util.*

class RSAEncTest {
    val keyPairGenerator = RSA()
    val privateKey: String = Base64.getEncoder().
    encodeToString(keyPairGenerator.privateKey.encoded)
    val publicKey: String = Base64.getEncoder().
    encodeToString(keyPairGenerator.publicKey.encoded)
    @Test
    fun testWithKotlinString() {
        val secretText = "Kotlin is a powerful programming language"
        val encryptedValue = keyPairGenerator.encryptMessage(secretText, publicKey)
        assert(keyPairGenerator.decryptMessage(encryptedValue, privateKey)==secretText)

    }
    @Test
    fun testWithIntellIjString() {
        val secretText = "InteliJ IDEA Community Edition"
        val encryptedValue = keyPairGenerator.encryptMessage(secretText, publicKey)
        assert(keyPairGenerator.decryptMessage(encryptedValue, privateKey)==secretText)
    }
    @Test
    fun testWithAlgorithmjString() {
        val secretText = "Algorithm-Repo"
        val encryptedValue = keyPairGenerator.encryptMessage(secretText, publicKey)
        assert(keyPairGenerator.decryptMessage(encryptedValue, privateKey)==secretText)
    }
}