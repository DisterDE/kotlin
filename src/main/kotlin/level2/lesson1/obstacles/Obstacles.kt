package level2.lesson1.obstacles

import level2.lesson1.competitors.Competitor

interface Obstacle {
    fun doIt(competitor: Competitor)
}

internal class Cross(
    private val distance: Int
) : Obstacle {
    override fun doIt(competitor: Competitor) {
        competitor.run(distance)
    }
}

internal class Pool(
    private val distance: Int
) : Obstacle {
    override fun doIt(competitor: Competitor) {
        competitor.swim(distance)
    }
}

internal class Wall(
    private val height: Int
) : Obstacle {
    override fun doIt(competitor: Competitor) {
        competitor.jump(height)
    }
}