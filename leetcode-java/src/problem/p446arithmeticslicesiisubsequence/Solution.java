package problem.p446arithmeticslicesiisubsequence;

/**
 * 446. Arithmetic Slices II - Subsequence
 *
 * https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
 *
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and
 * if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 */

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
    }

    public static void main(String[] args) {
        assert new Solution().numberOfArithmeticSlices(new int[]{2,4,6,8,10}) == 7;
        assert new Solution().numberOfArithmeticSlices(new int[]{7,7,7,7,7}) == 16;
    }

}
