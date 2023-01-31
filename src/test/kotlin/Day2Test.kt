import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day2Test {
    @Test
    fun day2() {
        val results = Day2(getResource("Day2Example.txt")).solve()

        assertEquals(15, results.firstPart)
        assertEquals(12, results.secondPart)
    }
}