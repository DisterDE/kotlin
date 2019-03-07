package level3.lesson1.fruitboxes

fun main() {
    val apples = Box<Apple>()
    val apples2 = Box<Apple>()
    val oranges = Box<Orange>()

    apples.add(Apple())
    apples.add(Apple())
    apples2.add(Apple())
    oranges.add(Orange())
    oranges.add(Orange())

    println("apples weight: ${apples.getWeight()}")
    println("apples2 weight: ${apples2.getWeight()}")
    println("oranges weight: ${oranges.getWeight()}")

    println("move apples to apples2")
    apples.moveFruitsTo(apples2)

    println("apples weight: ${apples.getWeight()}")
    println("apples2 weight: ${apples2.getWeight()}")

    println("oranges == apples: ${apples.compare(oranges)}")
    println("oranges == apples2: ${apples2.compare(oranges)}")
}