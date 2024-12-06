package day03

import println
import readInput
import kotlin.math.abs

fun main() {


    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
        return input.sumOf { entry ->
            regex.findAll(entry).map {
                val pair = it.value
                    .replace("mul(", "")
                    .replace(")", "")
                    .split(",")
                    .map { it.toInt() }
                pair[0] * pair[1]
            }.sum()
        }
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val testInput = readInput("day03/input_test")
    check(part1(testInput) == 161)

    val input = readInput("day03/input")
    part1(input).println()
    part2(input).println()
}
