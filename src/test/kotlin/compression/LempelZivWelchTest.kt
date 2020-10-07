package compression

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

val loremIpsum = """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor suscipit interdum. Vestibulum ac molestie felis. Phasellus facilisis ultricies purus eget ultrices. Donec cursus mi sit amet eleifend fermentum. Donec ut leo blandit tellus auctor eleifend. Aenean efficitur euismod leo, sed consequat elit hendrerit ac. Vivamus fermentum lobortis mi, sit amet mattis mauris euismod quis.

    Integer suscipit elit ligula, eget luctus felis rutrum sed. Ut sit amet nisi ac ante sodales rutrum. Fusce porta pulvinar felis ut commodo. Phasellus non pharetra nulla. In a pharetra nibh. Morbi et interdum eros. Etiam vitae feugiat magna, eu blandit mi. Mauris sed volutpat purus. Aliquam tempus porttitor arcu vel rutrum. Vivamus consectetur eu quam sed mollis. Phasellus consectetur laoreet libero, a convallis enim hendrerit non.

    Etiam tristique iaculis fringilla. Quisque nec odio tortor. Integer luctus sollicitudin magna sit amet volutpat. In hac habitasse platea dictumst. Mauris euismod, metus fringilla pharetra elementum, sapien enim sollicitudin diam, sed vulputate justo nibh eget augue. Quisque sit amet fringilla magna, in pellentesque sem. Cras gravida ipsum in vehicula blandit. Morbi lobortis porta nulla at ultricies. Vestibulum eget velit id mauris sagittis semper eget et ante. Fusce ac nisi ut tellus lacinia tincidunt nec quis orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque non consectetur justo, id vehicula ex. Aenean non volutpat ipsum.

    Aenean iaculis eleifend mauris sit amet consequat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec eget venenatis augue. Etiam viverra interdum enim tincidunt dignissim. Integer in metus est. Sed placerat ante ac nisi ullamcorper ultrices. Nullam arcu nisi, sodales eget scelerisque vel, porttitor id turpis. Mauris urna quam, facilisis ut turpis in, accumsan malesuada dui. Praesent maximus auctor urna. Vivamus blandit dignissim iaculis. Vestibulum ornare odio at tristique tempor. Phasellus quis purus dui. Cras vitae velit vehicula, volutpat justo id, hendrerit turpis. Ut eleifend, neque eu iaculis maximus, sapien ante rhoncus magna, in tristique tortor ipsum in nunc. Etiam ante felis, porttitor in neque id, consectetur imperdiet sem. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

    Duis venenatis mi et urna posuere facilisis. Proin vulputate pretium posuere. Duis a volutpat leo. Vivamus tincidunt, est eu hendrerit efficitur, erat sapien commodo lacus, vel pellentesque nulla ligula a mi. Mauris pretium malesuada sem, sit amet ultrices nibh porta suscipit. Phasellus ac lacus at magna vehicula aliquam. Fusce lacinia neque ut venenatis laoreet.
""".trimIndent()

@RunWith(Parameterized::class)
class IsIntegerTest(private val number: Float, private val isInteger: Boolean) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(0, true),
            arrayOf(1, true),
            arrayOf(2, true),
            arrayOf(10_000_000_000, true), // Precision Error to but test pass

            arrayOf(1.5f, false),
            // arrayOf(2.999999999999f, false), // Precision Error
            arrayOf(0.111111111111f, false),
            // arrayOf(10_000_000_000.5f, false), // Precision Error
        )
    }

    @Test
    fun testIsInteger() {
        assertEquals(isInteger, number.isInteger())
    }
}

@RunWith(Parameterized::class)
class ByteArrayToBitArrayTest(private val input: ByteArray, private val expected: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(byteArrayOf(72, 98), "0100 1000 0110 0010"),
        )
    }

    @Test
    fun testIsInteger() {
        val result = input.toBitArray().toList()
        val expected = expected.replace(" ", "").map { it.toInt() - '0'.toInt() }
        assertEquals(expected, result)
    }
}


class LempelZivWelchTest {
    private fun <T> assertEqualArrays(array1: Array<T>, array2: Array<T>) {
        assertEquals(array1.size, array2.size, "Lengths different")
        for (i in array1.indices)
            assertEquals(array1[i], array2[i], "index: $i => 1: ${array1[i]}, 2: ${array2[i]}")
    }

    @Test
    fun testCompression1() {
        val data = "Hello hello I'm a data.".toByteArray().toBitArray()
        val expected = "001000010000111000010100110011000100110110111010000000010110011000001001010111010011010010001101111001001000111011111011010101011000001010011000110000010000000000011100001000001011111000010001001010100001010000000"
            .map { it.toInt() - '0'.toInt() }.toTypedArray()
        val result = compressDataLzw(data)
        assertEqualArrays(expected, result)
    }

    @Test
    fun testDecompression1() {
        val data = "001000010000111000010100110011000100110110111010000000010110011000001001010111010011010010001101111001001000111011111011010101011000001010011000110000010000000000011100001000001011111000010001001010100001010000000"
            .map { it.toInt() - '0'.toInt() }.toTypedArray()
        val expected = "010010000110010101101100011011000110111100100000011010000110010101101100011011000110111100100000010010010010011101101101001000000110000100100000011001000110000101110100011000010010111000000"
            .map { it.toInt() - '0'.toInt() }.toTypedArray()
        val result = decompressDataLzw(data)
        assertEqualArrays(expected, result)
    }
/*

    @Test(timeout = 1000)
    fun test1() {
        val data = "Hello hello I'm a data.".toByteArray().toBitArray()
        val compressedData = compressDataLzw(data)
        val decompressedData = decompressDataLzw(compressedData)
        assertEqualArrays(data, decompressedData)
    }

    @Test(timeout = 1000)
    fun test2() {
        val data = loremIpsum.toByteArray().toBitArray()
        val compressedData = compressDataLzw(data)
        val decompressedData = decompressDataLzw(compressedData)
        assertEqualArrays(data, decompressedData)
    }
*/

}
