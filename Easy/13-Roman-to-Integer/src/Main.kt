class Solution {
    private fun symToVal(symbol: Char): Int {
        return when(symbol) {
            'M' -> 1000
            'D' -> 500
            'C' -> 100
            'L' -> 50
            'X' -> 10
            'V' -> 5
            else -> 1
        }
    }
    fun romanToInt(s: String): Int {
        var cumulativeSum = 0
        var tempSum = 0
        for (i in s.indices) {
            if (i != 0 && symToVal(s[i]) < symToVal(s[i - 1])) {
                cumulativeSum += tempSum
                tempSum = 0
            } else if (i != 0 && symToVal(s[i]) > symToVal(s[i - 1])) {
                tempSum = -tempSum
            }
            tempSum += symToVal(s[i])
        }
        return cumulativeSum + tempSum
    }
}

fun main() {
    val solution = Solution()
    println(solution.romanToInt("III"))
    println(solution.romanToInt("LVIII"))
    println(solution.romanToInt("MCMXCIV"))
}