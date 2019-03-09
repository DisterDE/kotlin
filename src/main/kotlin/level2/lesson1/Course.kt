package level2.lesson1

import level2.lesson1.obstacles.Obstacle

internal class Course(
    private vararg val obstacles: Obstacle
) {
    internal fun doIt(team: Team) {
        for (competitor in team.competitors) {
            for (obstacle in obstacles) {
                if (!competitor.onDistance) {
                    break
                }
                obstacle.doIt(competitor)
            }
        }
    }
}