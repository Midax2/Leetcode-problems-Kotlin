import kotlin.math.min

class Solution {
    fun addBinary(a: String, b: String): String {
        var charToRemember = '0'
        var result = ""
        var stopIndex = 0
        for (i in min(a.length, b.length) - 1 downTo 0) {
            stopIndex = i
            if (charToRemember == '0' && a[i] == '0' && b[i] == '0') {
                result = "0$result"
                charToRemember = '0'
            } else if (charToRemember == '0' && (a[i] == '1' && b[i] == '1')) {
                result = "0$result"
                charToRemember = '1'
            } else if (charToRemember == '0' && (a[i] == '1' || b[i] == '1')) {
                result = "1$result"
                charToRemember = '0'
            } else if (charToRemember == '1' && a[i] == '0' && b[i] == '0') {
                result = "1$result"
                charToRemember = '0'
            } else if (charToRemember == '1' && a[i] == '1' && b[i] == '1') {
                result = "1$result"
                charToRemember = '1'
            } else if (charToRemember == '1' && (a[i] == '1' || b[i] == '1')) {
                result = "0$result"
                charToRemember = '1'
            } else {
                continue
            }
        }
        val maxString = if (a.length > b.length) a else b
        for (i in stopIndex downTo 0) {
            if (a.length == b.length) break
            if (charToRemember == '0' && maxString[i] == '0') {
                result = "0$result"
                charToRemember = '0'
                break
            } else if ((charToRemember == '0' && maxString[i] == '1') || (charToRemember == '1' && maxString[i] == '0')) {
                result = "1$result"
                charToRemember = '0'
                break
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
    println(solution.addBinary("11", "1"))
    println(solution.addBinary("1010", "1011"))
    println(solution.addBinary("111", "1"))
}