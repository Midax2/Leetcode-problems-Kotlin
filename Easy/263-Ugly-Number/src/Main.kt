class Solution {
    fun isUgly(n: Int): Boolean {
        var isUgly = false
        if (n == 1) return true
        else if (n <= 0 ) return false
        if (n % 2 == 0) {
            isUgly = isUgly(n / 2)
        } else if (n % 3 == 0) {
            isUgly = isUgly(n / 3)
        } else if (n % 5 == 0) {
            isUgly = isUgly(n / 5)
        }
        return isUgly
    }
}

fun main() {
    val solution = Solution()
    println(solution.isUgly(6))
    println(solution.isUgly(8))
    println(solution.isUgly(14))
    println(solution.isUgly(1))
}