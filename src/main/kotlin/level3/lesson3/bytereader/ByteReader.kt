package level3.lesson3.bytereader

import java.io.File
import kotlin.random.Random.Default.nextBytes

private const val FILE_SIZE = 50

private fun main() {
    val file = File("resources/byteReader.txt")
    file.writeBytes(nextBytes(FILE_SIZE))

    val result = file.readBytes()
    println(result.joinToString())
}
