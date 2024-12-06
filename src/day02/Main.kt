package day02

import println
import readInput
import kotlin.math.abs

fun main() {
    fun isSafe(report: List<Int>): Boolean {
        var increasing = false
        var decreasing = false
        for (index in 1 until report.size) {
            val difference = report[index - 1] - report[index]
            if (abs(difference) !in 1..3) return false
            if (difference > 0) increasing = true
            if (difference < 0) decreasing = true
            if (decreasing && increasing) return false
        }
        return true
    }

    fun isSafeDumping(report: List<Int>): Boolean {
        report.forEachIndexed { index, _ ->
            val dumpped = report.toMutableList()
            dumpped.removeAt(index)
            if (isSafe(dumpped)) return true
        }
        return false
    }

    fun part1(input: List<String>): Int =
        input
            .map { report -> report.split(" ").map(String::toInt) }
            .count(::isSafe)


    fun part2(input: List<String>): Int =
        input
            .map { report -> report.split(" ").map(String::toInt) }
            .count {
                isSafe(it) || isSafeDumping(it)
            }


    val testInput = readInput("day02/input_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day02/input")
    part1(input).println()
    part2(input).println()
}
