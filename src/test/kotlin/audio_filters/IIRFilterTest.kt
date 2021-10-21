package audio_filters

import org.junit.Test

class IIRFilterTest {
    @Test
    fun iirFilterTestDefault() {
        // Default behavior is to just return the sample
        val filter = IIRFilter(10)
        val sample = 0.5
        assert(filter.process(sample) == sample)
    }

    @Test
    fun iirFilterTestLowPass() {
        // Butterworth low-pass filter with Fc=10_000
        val filter = IIRFilter(2)
        filter.setCoeffs(
            listOf(1.0, -0.3075651627667613, 0.18834053593286307),
            listOf(0.22019384329152544, 0.4403876865830509, 0.22019384329152544)
        )

        val samples = listOf(0.5, 1.0, -0.3)
        val expected = listOf(0.11009692164576272, 0.47424966420914927, 0.6095534171786035)

        for (i in samples.indices) {
            val result = filter.process(samples[i])
            assert(result == expected[i]) { "Expected ${expected[i]}, got $result" }
        }
    }
}
