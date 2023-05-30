class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder()
        var i = 0
        var j = 0

        while (i < word1.length || j < word2.length) {
            if (i < word1.length) {
                result.append(word1[i])
                i++
            }
            if (j < word2.length) {
                result.append(word2[j])
                j++
            }
        }
        return result.toString()
    }

    fun fastMergeAlternately(word1: String, word2: String): String {
        val res = StringBuilder()
        for (i in 0..Math.max(word1.length, word2.length)) {
            if (i in word1.indices) {
                res.append(word1[i])
            }
            if (i in word2.indices) {
                res.append(word2[i])
            }
        }
        return res.toString()
    }
}

fun main() {
    val s1 = "ab"
    val s2 = "pqrs"
    val expected = "apbqrs"
    val actual = Solution().mergeAlternately(s1, s2)
    assert(expected == actual) { "Expected: $expected, Actual: $actual" }

    val word1 = "abc"
    val word2 = "pqr"
    val expected2 = "apbqcr"
    val actual2 = Solution().mergeAlternately(word1, word2)
    assert(expected2 == actual2) { "Expected: $expected2, Actual: $actual2" }

    val word3 = "abcd"
    val word4 = "pq"
    val expected3 = "apbqcd"
    val actual3 = Solution().mergeAlternately(word3, word4)
    assert(expected3 == actual3) { "Expected: $expected3, Actual: $actual3" }
}