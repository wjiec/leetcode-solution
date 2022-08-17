package problem.p1529minimumsuffixflips;

/**
 * 1529. Minimum Suffix Flips
 *
 * https://leetcode.cn/problems/minimum-suffix-flips/
 *
 * You are given a 0-indexed binary string target of length n.
 * You have another binary string s of length n that is initially set to all zeros.
 * You want to make s equal to target.
 *
 * In one operation, you can pick an index i where 0 <= i < n and flip all bits in the
 * inclusive range [i, n - 1]. Flip means changing '0' to '1' and '1' to '0'.
 *
 * Return the minimum number of operations needed to make s equal to target.
 */

public class Solution {

    public int minFlips(String target) {
        int ans = 0;
        for (var c : target.toCharArray()) {
            if (c - '0' != ans % 2) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        assert new Solution().minFlips("10111") == 3;
        assert new Solution().minFlips("101") == 3;
        assert new Solution().minFlips("00000") == 0;
    }

}
