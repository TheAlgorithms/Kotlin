import encryption.Caesar
import org.junit.Test

class CaesarEncryptionTest{

    @Test
    fun testWithKotlinStringAndKey8() {
        val string = "Kotlin is a powerful programming language"
        val encoded = Caesar.encrypt(string, 8)
        assert(Caesar.decrypt(encoded,8)== string)

    }
    @Test
    fun testWithIntellIjStringAndKey10() {
        val string = "InteliJ IDEA Community Edition"
        val encoded = Caesar.encrypt(string, 10)
        assert(Caesar.decrypt(encoded,10)== string)

    }

    @Test
    fun testWithAlgorithmjStringAndKey3() {
        val string = "Algorithm-Repo"
        val encoded = Caesar.encrypt(string, 3)
        assert(Caesar.decrypt(encoded,3)== string)

    }







}