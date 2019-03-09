package level2.lesson1

import level2.lesson1.competitors.Cat
import level2.lesson1.competitors.Dog
import level2.lesson1.competitors.Human
import level2.lesson1.obstacles.Cross
import level2.lesson1.obstacles.Pool
import level2.lesson1.obstacles.Wall

fun main() {
    val c = Course(
        Cross(700),
        Wall(6),
        Pool(400)
    )

    val team = Team(
        "Pro100 team",
        Human("Каррох"),
        Dog("Бейнхаллоу"),
        Cat("Азраф")
    )

    c.doIt(team)
    team.showResult()
}