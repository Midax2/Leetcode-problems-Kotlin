class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (row in 0..<n-1) {
            for (i in n - 1 downTo row) {
                val temp = matrix[row][i]
                matrix[row][i] = matrix[i][row]
                matrix[i][row] = temp
            }
            matrix[row].reverse()
        }
        matrix[n - 1].reverse()
    }
}

fun main() {
    val solution = Solution()
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    solution.rotate(matrix)
    println(matrix.contentDeepToString())
    println("=======================")
    val matrix2 = arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
    solution.rotate(matrix2)
    println(matrix2.contentDeepToString())
}