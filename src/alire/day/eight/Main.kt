package alire.day.eight

import java.io.File

class Tree(val height:Int, var surMap: Map<String, Crdint?>)
var treeMap = mutableMapOf<Crdint, Tree>()
var width = 0

fun main() {
    var lines = 0
    File("src/alire/day/eight/input.txt").forEachLine {line ->
        val charLine = line.toCharArray()
        width = charLine.size
        for (i in charLine.indices) {
            val top = if(lines-1<-1) null else Crdint(lines-1,i)
            val bot = if(lines+1>100) null else Crdint(lines+1,i)
            val lef = Crdint(lines, i-1)
            val rig = if (i+1>width) null else Crdint(lines, i+1)
            treeMap[Crdint(lines,i)] = Tree(cToInt(charLine[i]), mapOf("top" to top, "bot" to bot, "lef" to lef, "rig" to rig))
        }
        lines++
    }
    part1()
    part2()
}

fun part1() {
    var visTrees = 0
    treeMap.forEach { (_,v)->
        val smaller = mutableMapOf("top" to false,"bot" to false, "lef" to false, "rig" to false)
        for (i in v.surMap.keys) {
            var t = treeMap[v.surMap[i]]
            var c = t?.surMap?.get(i)
            smaller[i] = c==null
            while (c != null) {
                smaller[i] = v.height > (t?.height ?: 0)
                t = treeMap[t?.surMap?.get(i)]
                c = t?.surMap?.get(i)
                if (smaller[i] == false)
                    break
            }
            if (smaller.any{(_,v)-> v})
                break
        }
        visTrees = if (smaller.any{(_,v)-> v}) visTrees+1 else visTrees
    }
    println(visTrees)
}

fun part2() {
    var toptier = 0
    treeMap.forEach { (_,v)->
        val top:MutableMap<String, Int> = mutableMapOf("top" to 0,"bot" to 0, "lef" to 0, "rig" to 0)
        for (i in v.surMap.keys) {
            var t = treeMap[v.surMap[i]]
            var c: Crdint? = t?.surMap?.get(i) ?: continue
            while (c != null ) {
                top[i] = top[i]!! + 1
                if (v.height <= t!!.height)
                    break
                t = treeMap[t.surMap[i]]
                c = t?.surMap?.get(i)
            }
        }
        toptier = if((top["top"]!!*top["bot"]!!*top["lef"]!!*top["rig"]!!) > toptier)
            top["top"]!!*top["bot"]!!*top["lef"]!!*top["rig"]!! else toptier
    }
    println(toptier)
}

fun cToInt(c:Char):Int {return c.toString().toInt() }

class Crdint(var row:Int, var col:Int){
    override fun equals(other: Any?)
    = (other is Crdint)
            && row == other.row
            && col == other.col
    override fun hashCode(): Int {
        return 31 * row + col
    }
}
