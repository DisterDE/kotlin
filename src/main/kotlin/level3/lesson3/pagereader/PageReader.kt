package level3.lesson3.pagereader

import java.io.File
import java.io.RandomAccessFile

private const val PAGE_SIZE = 1_800
private const val BIG_FILE_SIZE = 10_000_000
private const val PAGE_COUNT = BIG_FILE_SIZE / PAGE_SIZE + 1

private fun main() {
    val file = genBigFile()

    while (true) {
        val pageNumber = getPageNumber()
        if (pageNumber !in 0 until PAGE_COUNT) {
            println("Page $pageNumber is not available")
            continue
        }

        val bytePage = readPage(file, pageNumber)
        printPage(bytePage)
        break
    }
}

private fun readPage(file: File, pageNumber: Int): ByteArray {
    val raf = RandomAccessFile(file, "r")
    raf.seek((pageNumber * PAGE_SIZE).toLong())
    val remainder = BIG_FILE_SIZE - (pageNumber * PAGE_SIZE)
    val bytePage = ByteArray(if (remainder > PAGE_SIZE) PAGE_SIZE else remainder)
    raf.read(bytePage)
    return bytePage
}

private fun printPage(buffer: ByteArray) {
    val result = buffer.map {
        it.toChar()
    }

    println(result.joinToString(""))
}

private fun getPageNumber(): Int {
    return try {
        System.`in`.bufferedReader()
            .readLine()
            .split(" ")[0]
            .toInt() - 1
    } catch (e: NumberFormatException) {
        println("Not number")
        -1
    }
}

private fun genBigFile(): File {
    val file = File("resources/bigFile.txt")
    val fileWriter = file.outputStream().buffered(BIG_FILE_SIZE)
    var filler = 'a'
    for (i in 0..BIG_FILE_SIZE) {
        if (i % PAGE_SIZE == 0 && i != 0) {
            filler++
        }

        if (filler > 'z') {
            filler = 'a'
        }

        fileWriter.write(filler.toInt())
    }
    return file
}
