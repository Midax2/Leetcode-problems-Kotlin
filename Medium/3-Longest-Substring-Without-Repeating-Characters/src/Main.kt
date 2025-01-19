class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxSubStringLength = 0
        var alreadySeen = hashSetOf<Char>()
        for (i in s.indices) {
            for (j in i..<s.length) {
                if (!alreadySeen.contains(s[j])) alreadySeen.add(s[j])
                else break
                val tempSub = s.substring(i, j + 1)
                if (tempSub.length > maxSubStringLength) {
                    maxSubStringLength = tempSub.length
                }
            }
            alreadySeen.clear()
        }
        return maxSubStringLength
    }
}

fun main() {
    val solution = Solution()
    println(solution.lengthOfLongestSubstring("abcabcbb"))
    println(solution.lengthOfLongestSubstring("bbbbb"))
    println(solution.lengthOfLongestSubstring("pwwkew"))
}