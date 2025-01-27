class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val used: MutableMap<Int, Int> = mutableMapOf()
        for (i in nums.indices) {
            if (used[target - nums[i]] != null) return intArrayOf(used[target - nums[i]]!!, i)
            else if (used[nums[i]] != null) continue
            used[nums[i]] = i
        }
        return intArrayOf(0, 0)
    }
}

fun main() {
    val solution = Solution()
    println(solution.twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(solution.twoSum(intArrayOf(3,2,4), 6).contentToString())
}