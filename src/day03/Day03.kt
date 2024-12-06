package day03

import println
import readInput

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

    fun part2Fail(input: List<String>): Int { //Failing too low
        val regexBorders = Regex("(don\\'t\\(\\))(.*)(do\\(\\))")
        val sanitizedInput = input.map {
            it.replace(regexBorders, "")
        }
        return part1(sanitizedInput)
    }

    fun part2(input: List<String>): Int {
        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)|(don\\'t\\(\\))|(do\\(\\))")
        var enabled = true
        var result = 0
        input.forEach { entry ->
            regex
                .findAll(entry)
                .map { it.value }
                .forEach {
                    if (it == "don't()") enabled = false
                    if (it == "do()") enabled = true
                    if (enabled && it.startsWith("mul")) {
                        val operands = it
                            .replace("mul(", "")
                            .replace(")", "")
                            .split(",").map { it.toInt() }
                        result += operands[0] * operands[1]
                    }
                }
        }
        return result
    }


    val testInput = readInput("day03/input_test")
    check(part1(testInput) == 161)

    val input = readInput("day03/input")
    part1(input).println()
    part2(input).println()
}
