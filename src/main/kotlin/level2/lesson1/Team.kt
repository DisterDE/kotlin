package level2.lesson1

import level2.lesson1.competitors.Competitor

internal class Team(
    private val name: String,
    internal vararg val competitors: Competitor
) {
    fun showResult() {
        val (winners, losers) = competitors.partition { it.onDistance }
        if (winners.isNotEmpty() || losers.isNotEmpty()) {
            println("===================================================")
            println("Результаты команды $name:")
            if (winners.isNotEmpty()) {
                println("Победители из команды $name:")
                winners.forEach {
                    println("   -> ${it.name}")
                }
            }
            if (losers.isNotEmpty()) {
                println("Проигравшие из команды $name:")
                losers.forEach {
                    println("   -> ${it.name}")
                }
            }
        }
    }

    fun showWinners() {
        println("===================================================")
        println("Победители из команды $name:")
        competitors.filter { it.onDistance }
            .forEach {
                println("   -> ${it.name}")
            }
    }
}