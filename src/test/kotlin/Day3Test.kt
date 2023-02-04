import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day3Test {

    @Test
    fun compart() {
        val line = "vJrwpWtwJgWrhcsFMMfFFhFp"
        val r = compartiment(line)

        assertEquals("vJrwpWtwJgWr", r.first)
        assertEquals("hcsFMMfFFhFp", r.second)
    }

    @Test
    fun findCommon() {
        val comp = Pair("vJrwpWtwJgWr", "hcsFMMfFFhFp")
        val r = findCommon(comp.first, comp.second)
        assertEquals('p', r)
    }

    @Test
    fun calc() {
        mapOf<Char, Int>(
            'a' to 1,
            'z' to 26,
            'A' to 27,
            'Z' to 52,
            'p' to 16,
            'L' to 38,
            'P' to 42,
            'v' to 22,
            't' to 20,
            's' to 19,
        ).map {
            assertEquals(it.value, calcScore(it.key))
        }
    }

    @Test
    fun sample() {
        val day3 = Day3(getResource("Day3Example.txt"))
        val answer = day3.solve()

        assertEquals(157, answer.first)
        assertEquals(70, answer.second)
    }
}