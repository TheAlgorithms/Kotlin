package audio_filters

/**
 * Implement N-order IIR Filter using 1st form
 * Assumes inputs are normalized to [-1, 1]
 *
 * @param order order of the IIR Filter
 */
class IIRFilter(val order: Int) {
    private val coeffsA = MutableList(order+1) { if (it == 0) 1.0 else 0.0 }
    private val coeffsB = MutableList(order+1) { if (it == 0) 1.0 else 0.0 }
    private val historyX = MutableList(order) { 0.0 }
    private val historyY = MutableList(order) { 0.0 }

    /**
     * Process a single sample
     *
     * @param sample Sample to process
     * @return processed sample
     */
    fun process(sample: Double): Double {
        var result = 0.0

        for (i in 1..order) {
            result += coeffsB[i] * historyX[i-1] - coeffsA[i] * historyY[i-1]
        }

        result = (result + coeffsB[0] * sample) / coeffsA[0]

        for (i in 1 until order) {
            historyX[i] = historyX[i-1]
            historyY[i] = historyY[i-1]
        }

        historyX[0] = sample
        historyY[0] = result

        return result
    }

    /**
     * Set the A/B coefficients, where B is the numerator and A is the denominator
     */
    fun setCoeffs(coeffsA: List<Double>, coeffsB: List<Double>) {
        if (coeffsA.size != order+1) {
            throw IllegalArgumentException("Expected coeffsA to have ${order+1} values for $order-order IIR filter, got ${coeffsA.size}")
        }

        if (coeffsA[0] == 0.0) {
            throw IllegalArgumentException("coeffsA[0] cannot be 0.0!")
        }

        if (coeffsB.size != order+1) {
            throw IllegalArgumentException("Expected coeffsA to have ${order+1} values for $order-order IIR filter, got ${coeffsB.size}")
        }

        for (i in 0..order) {
            this.coeffsA[i] = coeffsA[i]
            this.coeffsB[i] = coeffsB[i]
        }
    }
}
