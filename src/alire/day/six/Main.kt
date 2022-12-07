package alire.day.six

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/alire/day/six/input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    var i = 0

    for (char:Char in inputString) {
        var unique = true
        i++
        for (z in (0+i)..(13+i)) {
            for (c in (0+i)..(13+i)) {
                if (inputString[z] == inputString[c] && z != c) {
                    unique = false;
                    break;
                }
            }
        }
        if (i>=14 && unique) {
            println(i)
            break;
        }
    }

    /*File("src/alire/day/six/demo.txt").forEachLine {
    }*/
}