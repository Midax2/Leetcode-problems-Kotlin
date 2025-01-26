class Solution {
    fun isMatch(s: String, p: String): Boolean {
        var prevChar = s[0]
        var i = 0
        var flag = false
        for (ch in s) {
            flag = false
            if (i >= p.length) { return false}
            if (ch != p[i] && p[i] != '.' && i + 1 < p.length && p[i + 1] == '*') {
                i += 2
                if (i >= p.length) { return false}
            }
            if ((ch != prevChar && prevChar != '.') && p[i] == '*') {
                i++
                if (i >= p.length) { return false}
            }
            if (ch == p[i] || p[i] == '.') {
                prevChar = p[i++]
                flag = true
                continue
            } else if ((ch == prevChar || prevChar == '.') && p[i] == '*') {
                continue
            } else return false
        }
        if (flag) { i-- }
        return i + 1 >= p.length
    }
}

fun main() {
    val solution = Solution()
//    println(solution.isMatch(s="aa", p="a"))
//    println(solution.isMatch(s="aa", p="a*"))
//    println(solution.isMatch(s="ab", p=".*"))
//    println(solution.isMatch(s="ab", p=".*c"))
    println(solution.isMatch(s="aaa", p="aaaa"))
    println(solution.isMatch(s="aab", p="c*a*b"))
}