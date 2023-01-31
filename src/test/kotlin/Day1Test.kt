import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day1Test {

    @Test
    fun sample() {
        val input = getResource("Day1Example.txt")
        val day1 = Day1(input)

        val results = day1.solve()

        assertEquals(24000, results.part1)
        assertEquals(45000, results.part2)
    }
}