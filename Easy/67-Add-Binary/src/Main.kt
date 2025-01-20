import kotlin.math.max
import kotlin.math.min

class Solution {
    fun addBinary(a: String, b: String): String {
        var charToRemember = '0'
        var result = ""
        val stopIndex = max(a.length, b.length) - min(a.length, b.length) - 1
        val maxString = if (a.length > b.length) a else b
        val minString = if (a.length <= b.length) a else b
        for (i in min(a.length, b.length) - 1 downTo 0) {
            if (charToRemember == '0' && maxString[i + stopIndex + 1] == '0' && minString[i] == '0') {
                result = "0$result"
                charToRemember = '0'
            } else if (charToRemember == '0' && (maxString[i + stopIndex + 1] == '1' && minString[i] == '1')) {
                result = "0$result"
                charToRemember = '1'
            } else if (charToRemember == '0' && (maxString[i + stopIndex + 1] == '1' || minString[i] == '1')) {
                result = "1$result"
                charToRemember = '0'
            } else if (charToRemember == '1' && maxString[i + stopIndex + 1] == '0' && minString[i] == '0') {
                result = "1$result"
                charToRemember = '0'
            } else if (charToRemember == '1' && maxString[i + stopIndex + 1] == '1' && minString[i] == '1') {
                result = "1$result"
                charToRemember = '1'
            } else if (charToRemember == '1' && (maxString[i + stopIndex + 1] == '1' || minString[i] == '1')) {
                result = "0$result"
                charToRemember = '1'
            } else {
                continue
            }
        }
        for (i in stopIndex downTo 0) {
            if (a.length == b.length) break
            if (charToRemember == '0' && maxString[i] == '0') {
                result = "0$result"
                charToRemember = '0'
            } else if ((charToRemember == '0' && maxString[i] == '1') || (charToRemember == '1' && maxString[i] == '0')) {
                result = "1$result"
                charToRemember = '0'
            } else {
                result = "0$result"
                charToRemember = '1'
            }
        }
        if (charToRemember == '1') {
            result = "1$result"
        }
        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.addBinary("1", "1"))
    println(solution.addBinary("1010", "1011"))
    println(solution.addBinary("111", "1"))
    println(solution.addBinary("100", "110010"))
}