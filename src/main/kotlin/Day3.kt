data class Day3Answer(val first: Int, val second: Int)

fun compartiment(line : String) : Pair<String, String> {
    return Pair(line.substring(0 until (line.length/2)), line.substring(line.length/2))
}

fun findCommon(a : String, b : String) : Char? {
    return a.find { b.contains(it) }
}

fun calcScore(c : Char) : Int {
    return if(c.isLowerCase()) {
        c.code - 96
    } else {
        c.code - 38
    }
}

fun firstAnswer(lines: List<String>) : Int {
    return lines.map { compartiment(it) }
        .mapNotNull { findCommon(it.first, it.second) }
        .sumOf { calcScore(it) }
}

fun secondAnswer(lines : List<String>) : Int {
    return lines
        .asSequence()
        .withIndex()
        .groupBy { it.index / 3 }
        .map { it.value.map { a -> a.value } }
        .map { it.sortedBy { l -> l.length } }
        .mapNotNull { it[0].find { c -> it[1].contains(c) && it[2].contains(c) } }
        .sumOf { calcScore(it) }
}

class Day3(private val input : String) {
    fun solve() : Day3Answer {
        val lines = input.split("\r\n","\n")
        val score = firstAnswer(lines)
        val second = secondAnswer(lines)
        return Day3Answer(score, second)
    }
}