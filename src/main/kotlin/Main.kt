import Day1

fun main() {
    println("Welcome to AOC 2022")

    val day1 = Day1(getResource("Day1Input.txt")).solve()
    println("Day 1 solution: $day1")

    val day2 = Day2(getResource("Day2input.txt")).solve()
    println("Day 2 solution: $day2")

    val day3 = Day3(getResource("Day3input.txt")).solve()
    println("Day 3 solution: $day3")
}