package level2.lesson1.competitors

import kotlin.random.nextInt

internal class Human(
    name: String
) : Competitor(
    name,
    random.nextInt(600..800),
    random.nextInt(4..6),
    random.nextInt(300..600)
)