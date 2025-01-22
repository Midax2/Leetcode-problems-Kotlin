class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length) return -1
        for (i in 0..haystack.lastIndex) {
            if (i + needle.lastIndex > haystack.lastIndex) return -1
            if (haystack[i] == needle[0]) {
                for (j in 0..needle.lastIndex) {
                    if (haystack[i + j] != needle[j]) break
                    if (j == needle.lastIndex) return i
                }
            }
        }
        return -1
    }
}

fun main() {
    val solution = Solution()
    println(solution.strStr("hello", "ll"))
    println(solution.strStr("aaaaa", "bba"))
    println(solution.strStr("sadbutsad", "sad"))
    println(solution.strStr("leetcode", "leeto"))
}