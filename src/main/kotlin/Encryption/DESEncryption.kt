import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.crypto.SecretKey
import java.util.Arrays
import java.security.MessageDigest


class TripleDESDemo {
    fun encrypt(message: String): ByteArray {
        val md = MessageDigest.getInstance("md5")
        val digestOfPassword = md.digest("HG58YZ3CR9".toByteArray(charset("utf-8")))
        val keyBytes = Arrays.copyOf(digestOfPassword, 24)
        var j = 0
        var k = 16
        while (j < 8) {
            keyBytes[k++] = keyBytes[j++]
        }
        val key: SecretKey = SecretKeySpec(keyBytes, "DESede")
        val iv = IvParameterSpec(ByteArray(8))
        val cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key, iv)
        val plainTextBytes = message.toByteArray(charset("utf-8"))
        return cipher.doFinal(plainTextBytes)
    }

    fun decrypt(message: ByteArray?): String {
        val md = MessageDigest.getInstance("md5")
        val digestOfPassword = md.digest("HG58YZ3CR9".toByteArray(charset("utf-8")))
        val keyBytes = Arrays.copyOf(digestOfPassword, 24)
        var j = 0
        var k = 16
        while (j < 8) {
            keyBytes[k++] = keyBytes[j++]
        }
        val key: SecretKey = SecretKeySpec(keyBytes, "DESede")
        val iv = IvParameterSpec(ByteArray(8))
        val decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding")
        decipher.init(Cipher.DECRYPT_MODE, key, iv)
        val plainText = decipher.doFinal(message)
        return String(plainText)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = "Kotlin is a powerful programming language"
            val codedtext = TripleDESDemo().encrypt(text)
            val decodedtext = TripleDESDemo().decrypt(codedtext)
            println(codedtext)
            println(decodedtext)
        }
    }
}
