package day04

import println
import readInput

fun main() {
    fun List<List<Char>>.contains(word: String): Int {
        var pr: List<MutableList<Char>> = this.map { it.toMutableList() }
        var result = 0
        for (i in indices) {
            for (j in indices) {
                if (this[i][j] == word[0]) {
                    var horizonal = true
                    var vertical = true
                    var diagonal = true
                    for (k in word.indices) {
                        if (i + k < size && this[i + k][j] != word[k]) {
                            horizonal = false
                            pr[i + k][j] = '.'
                        }
                        if (j + k < size && this[i][j + k] != word[k]) {
                            vertical = false
                            pr[i][j+1] = '.'

                        }
                        if (i + k < size && j + k < size && this[i + k][j + k] != word[k]) {
                            diagonal = false
                            pr[i + k][j+1] = '.'

                        }
                    }
                    if (horizonal) ++result
                    if (vertical) ++result
                    if (diagonal) ++result

                }
            }
        }
        println(result)
        pr.forEach{
            it.forEach(::print)
            println()
        }
        return result
    }


    fun part1(input: List<String>): Int {
        return input.map { it.toCharArray().asList() }.contains("XMAS")
    }


    fun part2(input: List<String>): Int {
        input.map { it.toCharArray().asList() }.contains("XMAS")
        return 0
    }


    val testInput = readInput("day04/input_test")
    check(part1(testInput) == 19)
    //check(part2(testInput) == 4)

    val input = readInput("day04/input")
    part1(input).println()
    part2(input).println()
}
