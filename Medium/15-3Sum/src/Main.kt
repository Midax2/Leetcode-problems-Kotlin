class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer: MutableList<List<Int>> = mutableListOf()
        val newNums = nums.sorted()
        for (i in newNums.indices) {
            for (j in i + 1..<newNums.size) {
                val k = newNums.binarySearch(element = -(newNums[i] + newNums[j]), fromIndex = j + 1)
                if (k >= 0 && k != i && k != j && i != j) {
                    val newSet = listOf(newNums[i], newNums[j], newNums[k]).sorted()
                    if (answer.contains(newSet)) continue
                    answer.add(newSet)
                }
            }
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.threeSum(intArrayOf(0,0,0)).toString())
    println(solution.threeSum(intArrayOf(-1,0,1,2,-1,-4)).toString())
    println(solution.threeSum(intArrayOf(0,1,1)).toString())
    println(solution.threeSum(intArrayOf(-1,0,1,2,-1,-4,-2,-3,3,0,4)).toString())
}