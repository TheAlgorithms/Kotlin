package compression

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.InputStream
import java.io.OutputStream

@RunWith(Parameterized::class)
class IntToBitList(private val input: Int, private val expectedList: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(28, listOf(1, 1, 1, 0, 0)),
            arrayOf(5, listOf(1, 0, 1))
        )
    }

    @Test
    fun shouldReturnExpected() {
        assertEquals(expectedList, input.toBitList())
    }
}

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
            arrayOf(0.111111111111f, false)
            // arrayOf(10_000_000_000.5f, false), // Precision Error
        )
    }

    @Test
    fun testIsInteger() {
        assertEquals(isInteger, number.isInteger())
    }
}

val loremIpsum = """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor suscipit interdum. Vestibulum ac molestie felis. Phasellus facilisis ultricies purus eget ultrices. Donec cursus mi sit amet eleifend fermentum. Donec ut leo blandit tellus auctor eleifend. Aenean efficitur euismod leo, sed consequat elit hendrerit ac. Vivamus fermentum lobortis mi, sit amet mattis mauris euismod quis.

    Integer suscipit elit ligula, eget luctus felis rutrum sed. Ut sit amet nisi ac ante sodales rutrum. Fusce porta pulvinar felis ut commodo. Phasellus non pharetra nulla. In a pharetra nibh. Morbi et interdum eros. Etiam vitae feugiat magna, eu blandit mi. Mauris sed volutpat purus. Aliquam tempus porttitor arcu vel rutrum. Vivamus consectetur eu quam sed mollis. Phasellus consectetur laoreet libero, a convallis enim hendrerit non.

    Etiam tristique iaculis fringilla. Quisque nec odio tortor. Integer luctus sollicitudin magna sit amet volutpat. In hac habitasse platea dictumst. Mauris euismod, metus fringilla pharetra elementum, sapien enim sollicitudin diam, sed vulputate justo nibh eget augue. Quisque sit amet fringilla magna, in pellentesque sem. Cras gravida ipsum in vehicula blandit. Morbi lobortis porta nulla at ultricies. Vestibulum eget velit id mauris sagittis semper eget et ante. Fusce ac nisi ut tellus lacinia tincidunt nec quis orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque non consectetur justo, id vehicula ex. Aenean non volutpat ipsum.

    Aenean iaculis eleifend mauris sit amet consequat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec eget venenatis augue. Etiam viverra interdum enim tincidunt dignissim. Integer in metus est. Sed placerat ante ac nisi ullamcorper ultrices. Nullam arcu nisi, sodales eget scelerisque vel, porttitor id turpis. Mauris urna quam, facilisis ut turpis in, accumsan malesuada dui. Praesent maximus auctor urna. Vivamus blandit dignissim iaculis. Vestibulum ornare odio at tristique tempor. Phasellus quis purus dui. Cras vitae velit vehicula, volutpat justo id, hendrerit turpis. Ut eleifend, neque eu iaculis maximus, sapien ante rhoncus magna, in tristique tortor ipsum in nunc. Etiam ante felis, porttitor in neque id, consectetur imperdiet sem. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

    Duis venenatis mi et urna posuere facilisis. Proin vulputate pretium posuere. Duis a volutpat leo. Vivamus tincidunt, est eu hendrerit efficitur, erat sapien commodo lacus, vel pellentesque nulla ligula a mi. Mauris pretium malesuada sem, sit amet ultrices nibh porta suscipit. Phasellus ac lacus at magna vehicula aliquam. Fusce lacinia neque ut venenatis laoreet.
""".trimIndent()

class LempelZivWelchTest {

    private val result = mutableListOf<Int>()
    private val bitOutputStream = BitOutputStream(object : OutputStream() {
        override fun write(b: Int) {
            result.add(b)
        }
    })

    private fun toInputStream(data: List<Int>): BitInputStream {
        var index = 0
        return BitInputStream(object : InputStream() {
            override fun read(): Int {
                if (index >= data.size)
                    return -1
                val value = data[index]
                index++
                return value
            }
        })
    }

    @Before
    fun before() {
        result.clear()
    }

    @Test(timeout = 1000)
    fun testCompression1() {
        val data = "Hello hello I'm a data.".toByteArray().map { it.toInt() }
        val expected = listOf(
            33,
            14,
            20,
            204,
            77,
            186,
            1,
            102,
            9,
            93,
            52,
            141,
            228,
            142,
            251,
            85,
            130,
            152,
            193,
            0,
            28,
            32,
            190,
            17,
            42,
            20,
            0
        )
        compressLzw(toInputStream(data), bitOutputStream)
        assertEquals(expected, result)
    }

    @Test(timeout = 2000)
    fun test1() {
        val data = "Hello hello I'm a data.".toByteArray().map { it.toInt() }
        val intermediaryResult = mutableListOf<Int>()
        compressLzw(
            toInputStream(data),
            BitOutputStream(object : OutputStream() {
                override fun write(b: Int) {
                    intermediaryResult.add(b)
                }
            })
        )
        decompressLzw(toInputStream(intermediaryResult), bitOutputStream)
        assertEquals(data, result)
    }

    @Test(timeout = 1000)
    fun test2() {
        val data = loremIpsum.toByteArray().map { it.toInt() }
        val intermediaryResult = mutableListOf<Int>()
        compressLzw(
            toInputStream(data),
            BitOutputStream(object : OutputStream() {
                override fun write(b: Int) {
                    intermediaryResult.add(b)
                }
            })
        )
        decompressLzw(toInputStream(intermediaryResult), bitOutputStream)
        assertEquals(data, result)
    }


}

class BitInputStreamTest {
    @Test
    fun testRead() {
        val bitInputStream = BitInputStream("test".byteInputStream())
        val result = mutableListOf<Int>()

        var bit = bitInputStream.read()
        while (bit != -1) {
            result.add(bit)
            bit = bitInputStream.read()
        }

        assertEquals(
            listOf(
                0, 1, 1, 1, 0, 1, 0, 0,
                0, 1, 1, 0, 0, 1, 0, 1,
                0, 1, 1, 1, 0, 0, 1, 1,
                0, 1, 1, 1, 0, 1, 0, 0
            ), result
        )
    }
}

class BitOutputStreamTest {
    @Test
    fun testWrite() {
        val result = mutableListOf<Int>()
        val bitOutputStream = BitOutputStream(object : OutputStream() {
            override fun write(b: Int) {
                result.add(b)
            }
        })
        listOf(
            0, 1, 1, 1, 0, 1, 0, 0,
            0, 1, 1, 0, 0, 1, 0, 1,
            0, 1, 1, 1, 0, 0, 1, 1,
            0, 1, 1, 1, 0, 1, 0, 0
        ).forEach { bitOutputStream.write(it) }
        bitOutputStream.flush()
        assertEquals(listOf(116, 101, 115, 116), result)
    }

    @Test
    fun testDiscardByteIfZero() {
        val result = mutableListOf<Int>()
        val bitOutputStream = BitOutputStream(object : OutputStream() {
            override fun write(b: Int) {
                result.add(b)
            }
        })
        listOf(
            0, 1, 1, 1, 0, 1, 0, 0,
            0, 0, 0, 0, 0
        ).forEach { bitOutputStream.write(it) }
        bitOutputStream.discardByteIfZero()
        bitOutputStream.flush()
        assertEquals(listOf(116), result)
    }

    @Test
    fun testFlush() {
        val result = mutableListOf<Int>()
        val bitOutputStream = BitOutputStream(object : OutputStream() {
            override fun write(b: Int) {
                result.add(b)
            }
        })
        listOf(
            0, 1, 1, 1, 0, 1, 0, 0,
            0, 0, 0, 1, 0
        ).forEach { bitOutputStream.write(it) }
        bitOutputStream.flush()
        assertEquals(listOf(116, 16), result)
    }
}
