import java.util.*

class Aquarium {
    companion object {
        fun buildTank(volume: Int): Aquarium {
            val tank = Aquarium()
            tank.volume = volume
            return tank
        }
    }
    var volume: Int = 0
}

val net = "fishing net" to "catching"
val numbers = Triple(1, 2, 3)

val volumes = listOf(20, 50, 80)
val names = listOf("guppy", "salmon")
val fish = hashMapOf("guppy" to "Poecilia reticulata", "salmon" to "Oncorhynchus")
val mutableVolumes = mutableListOf(10, 40, 70)

const val TANKS = 3
object TankConstants {
    const val MAX_VOLUME = 200
}

fun String.hasVowel(): Boolean = this.any { it in "aeiouAEIOU" }

open class AquariumPlant(val color: String, val height: Int)
class GreenLeafyPlant(height: Int) : AquariumPlant("green", height)

fun AquariumPlant.isGreen(): Boolean = color == "green"
val AquariumPlant.plantColor: String get() = color

fun AquariumPlant?.plant() = this?.apply { println("Planting $this") }
fun AquariumPlant.describe() = println("Plant: $color, height $height")
fun GreenLeafyPlant.describe() = println("Leafy plant height: $height")

fun main() {
    val tank = Aquarium.buildTank(100)
    println("Made a tank with volume ${tank.volume}")

    println("net.first = ${net.first}, net.second = ${net.second}")
    val (tool, use) = net
    println("so $tool is for $use")

    println("triple: $numbers")
    val (a, b, c) = numbers
    println("split into $a, $b, $c")

    println("volumes sum = ${volumes.sum()}")
    println("names letters = ${names.sumOf { it.length }}")

    println("guppy species: ${fish["guppy"]}")
    println("shark? ${fish.getOrDefault("shark", "nope")}")

    mutableVolumes.add(90)
    mutableVolumes.remove(40)
    println("after changes: $mutableVolumes")
    println("reversed: ${mutableVolumes.reversed()}")
    println("has 70? ${mutableVolumes.contains(70)}")

    println("TANKS = $TANKS")
    println("max volume = ${TankConstants.MAX_VOLUME}")

    println("aquarium has vowel? ${"aquarium".hasVowel()}")
    println("rhythm has vowel? ${"rhythm".hasVowel()}")

    val plant = AquariumPlant("blue", 12)
    println("plant color = ${plant.plantColor}")
    println("is green? ${plant.isGreen()}")
    plant.describe()

    val leafy = GreenLeafyPlant(18)
    leafy.describe()
    val base: AquariumPlant = leafy
    base.describe()

    val nullPlant: AquariumPlant? = null
    nullPlant.plant()

    val real = AquariumPlant("yellow", 8)
    real.plant()

    val mixed = listOf(5, "algae", 2.5)
    println("mixed list: $mixed")
    println("volumes reversed: ${volumes.reversed()}")
}