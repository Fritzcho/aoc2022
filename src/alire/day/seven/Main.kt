package alire.day.seven

import java.io.File


fun main() {
    File("src/alire/day/seven/input.txt").forEachLine {
        println(it)
        when {
            it.startsWith("$ cd") -> getDir(it)
            it.startsWith("dir") -> isDir(it)
            it.first().isDigit() -> isDigit(it)
        }
    }

    //println(dirLst.filter { it.size <= 100000 }.sumOf { it.size })
    var ans = 0
    for (dir in dirLst) {
        if (dir.size<= 100000)
            ans += dir.size
    }
    println(ans)
}

var curDir = Directory("/", null)
var dirLst = mutableListOf(curDir)
var root = Directory("/", null)

fun getDir(s: String) {
    when (val cmd = s.drop(5)) {
        ".." -> curDir = curDir.dir ?: curDir
        "/" -> curDir = root
        else -> curDir = curDir.children.getValue(cmd)
    }
}

fun isDir(s:String) {
    val name = s.drop(4)
    val dir = Directory(name, curDir)
    if (!dirLst.any {it.name == name}) {
        dirLst.add(dir)
    }
    if (!curDir.children.containsKey(name)) curDir.children[name] = dir
}

fun isDigit(s:String) {
    val toAdd = s.split(" ").first().toInt()
    curDir.size += toAdd
    var p = curDir.dir
    while (p!=null) {
        p.size += toAdd
        p = p.dir
    }
}

class Directory(val name: String, val dir: Directory?) {
    val children = mutableMapOf<String, Directory>()
    var size = 0
}