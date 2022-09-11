package math

import org.junit.Test

class VolumeTest {
    @Test
    fun testCubeVolume() = assert(cubeVolume(2.0) == 8.0)

    @Test
    fun testRectPrismVolume() = assert(rectPrismVolume(2.0, 2.0, 2.0) == 8.0)

    @Test
    fun testTrianglePrismVolume() = assert(trianglePrismVolume(2.0, 2.0, 2.0) == 4.0)

    @Test
    fun testConeVolume() = assert(coneVolume(2.0, 3.0) == 12.56)

    @Test
    fun testPyramidVolume() = assert(pyramidVolume(2.0, 2.0, 3.0) == 4.0)

    @Test
    fun testSphereVolume() = assert(String.format("%.2f", sphereVolume(1.0)).toDouble() == 4.19)

    @Test
    fun testCylinderVolume() = assert(String.format("%.2f", cylinderVolume(1.0, 1.0)).toDouble() == 3.14)
}