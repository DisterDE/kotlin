package level3.lesson3.fileconnector

import java.io.File
import kotlin.random.Random.Default.nextBytes

private const val FILE_SIZE = 100

private fun main() {
    val fileList = genFileList()

    makeCommonFile(fileList)
}

fun makeCommonFile(files: List<File>) {
    val commonFile = File("resources/commonFileConnector.txt")
    for (file in files) {
        val bytes = file.readBytes()
        commonFile.appendBytes(bytes)
    }
}

private fun genFileList(): List<File> {
    val result = mutableListOf<File>()
    for (i in 1..5) {
        val file = File("resources/fileConnector$i.txt")
        file.writeBytes(nextBytes(FILE_SIZE))
        result.add(file)
    }
    return result
}
