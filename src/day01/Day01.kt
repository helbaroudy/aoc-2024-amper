package day01

import println
import readInput
import kotlin.math.abs

const val DELIMITER = "   "

fun main() {
    fun part1(input: List<String>): Int {
        val right = input.map { it.split(DELIMITER)[0].toInt() }.sorted()
        val left  = input.map { it.split(DELIMITER)[1].toInt() }.sorted()

        return right.mapIndexed { index, value ->
            abs(value - left[index])
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
