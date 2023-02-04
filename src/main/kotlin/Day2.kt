enum class RPS(val value : Int, val opCode : String, val playCode : String){
    Rock(1, "A", "X"),
    Paper(2, "B", "Y"),
    Scissors(3, "C", "Z");


    companion object {
        fun fromOpCode(opCode : String) : RPS {
            return RPS.values().find { it.opCode == opCode }!!
        }

        fun fromPlayCode(playCode: String) : RPS {
            return RPS.values().find { it.playCode == playCode }!!
        }
    }

    fun beats(other : RPS) : Boolean {
        return when(this) {
            Rock -> other == Scissors
            Paper -> other == Rock
            Scissors -> other == Paper
        }
    }

    fun getLoser() : RPS {
        return RPS
            .values()
            .filter { it != this }
            .find { !it.beats(this) }!!
    }

    fun getWinner() : RPS {
        return RPS
            .values()
            .filter { it != this }
            .find { it.beats(this) }!!
    }
}

fun interface HasScore {
    fun calcScore() : Int
}

data class Day2Answer(val firstPart: Int, val secondPart : Int)
data class FirstRound(val opponent: RPS, val me : RPS) : HasScore {
    override fun calcScore() : Int {
        return me.value + when {
            opponent == me -> 3
            me.beats(opponent) -> 6
            else -> 0
        }
    }
}

enum class Solution(val code: String){
    Lose("X"),
    Draw("Y"),
    Win("Z");

    companion object {
        fun fromCode(code: String) : Solution {
            return Solution.values().find { it.code == code }!!
        }
    }
}

data class SecoundRound(val opponent : RPS, val solution : Solution) : HasScore {
    override fun calcScore() : Int {
        return when(solution) {
            Solution.Lose -> opponent.getLoser().value
            Solution.Draw -> opponent.value + 3
            Solution.Win -> opponent.getWinner().value + 6
        }
    }
}

class Day2(private val input : String) {
    fun solve() : Day2Answer {
        val collected = input.split("\r\n", "\n")
            .filter { it.isNotEmpty() }
            .map{ it.split(" ") }

        val firstSolution = collected.map{ FirstRound(RPS.fromOpCode(it[0]), RPS.fromPlayCode(it[1]))}.sumOf { it.calcScore() }
        val secondSolution = collected.map { SecoundRound(RPS.fromOpCode(it[0]), Solution.fromCode(it[1])) }.sumOf { it.calcScore() }

        return Day2Answer(firstSolution, secondSolution)
    }

}