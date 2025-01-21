class Solution {
    fun myAtoi(s: String): Int {
        var isPositive: Boolean? = null
        var result = 0
        for (ch in s) {
            if (ch.isWhitespace() && isPositive == null) continue
            else if (isPositive == null && (ch == '+' || ch == '-')) {
                isPositive = when (ch) {
                    '+' -> true
                    '-' -> false
                    else -> null
                }
            } else if (!ch.isDigit()) {
                return when(isPositive) {
                    true -> result
                    false -> -result
                    null -> 0
                }
            } else if (result > Int.MAX_VALUE / 10 || result * 10 > Int.MAX_VALUE - ch.digitToInt()) {
                return when(isPositive) {
                    true -> Int.MAX_VALUE
                    false -> Int.MIN_VALUE
                    else -> 0
                }
            }
            else {
                result *= 10
                result += ch.digitToInt()
                if (isPositive == null) isPositive = true
            }
        }
        return when(isPositive) {
            true -> result
            false -> -result
            null -> 0
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.myAtoi("42"))
    println(solution.myAtoi("   -42"))
    println(solution.myAtoi("4193 with words"))
    println(solution.myAtoi("words and 987"))
    println(solution.myAtoi("-91283472332"))
    println(solution.myAtoi("-+1"))
    println(solution.myAtoi("1337c0d3"))
    println(solution.myAtoi("2147483646"))
}