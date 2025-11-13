import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open fun printSize() {
        println("Tank: ${width}x${length}x$height cm -> $volume liters")
    }

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000
        height = (water / (length * width)).toInt() + 5
    }
}

class TowerTank(override var height: Int, var diameter: Int) : Aquarium(diameter, diameter, height) {
    override var volume: Int
        get() = (diameter / 2.0 * diameter / 2.0 * height * PI / 1000).toInt()
        set(_) {}

    override fun printSize() {
        println("Tower tank: diameter = $diameter cm, height = $height cm -> $volume liters")
    }
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Plecostomus : FishAction, FishColor by GoldColor {
    override fun eat() = println("eating algae")
}

class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() = println("hunting...")
}

data class Decoration(val rocks: String)

enum class Direction { NORTH, SOUTH, EAST, WEST }

fun main() {
    val tank = Aquarium()
    tank.printSize()

    val fishTank = Aquarium(numberOfFish = 7)
    println("Tank for 7 fish:")
    fishTank.printSize()

    val tower = TowerTank(50, 30)
    tower.printSize()

    val pleco = Plecostomus()
    println("Pleco: ${pleco.color}")
    pleco.eat()

    val shark = Shark()
    println("Shark: ${shark.color}")
    shark.eat()

    val deco = Decoration("coral")
    val (rock) = deco
    println("Using $rock in tank")

    println("Directions: ${Direction.values().contentToString()}")
}