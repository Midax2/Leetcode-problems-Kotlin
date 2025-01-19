class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var currentInsertIndex = 0
        for (num in nums) {
            if (num != nums[currentInsertIndex]) {
                nums[++currentInsertIndex] = num
            }
        }
        return currentInsertIndex + 1
    }
}

fun main() {
    val solution = Solution()
    println(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    println(solution.removeDuplicates(intArrayOf(0, 1, 1, 2, 2, 3)))
}