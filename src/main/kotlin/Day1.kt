data class Day1Answers(val part1: Int, val part2: Int)

class Day1(val input: String) {
    fun solve() : Day1Answers {
        val collected =  input.split("\r\n", "\n")
            .fold(mutableListOf(mutableListOf<String>())){ acc, s ->
                if(s.isBlank()) {
                    acc.add(mutableListOf())
                }
                else {
                    acc.last().add(s)
                }
                acc
            }.map { it.sumOf { item -> item.toInt() } }

        val part1 = collected.max()

        val part2 = collected.sorted().reversed().subList(0, 3).sum()

        return Day1Answers(part1, part2)
    }
}