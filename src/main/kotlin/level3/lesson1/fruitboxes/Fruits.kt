package level3.lesson1.fruitboxes

sealed class Fruit(val weight: Double)

class Apple : Fruit(1.0)

class Orange : Fruit(1.5)