package weekly.bw138.B;

/**
 * 3271. Hash Divided String
 *
 * https://leetcode.cn/contest/biweekly-contest-138/problems/hash-divided-string/
 *
 * You are given a string s of length n and an integer k, where n is a multiple of k.
 *
 * Your task is to hash the string s into a new string called result, which has a length of n / k.
 *
 * First, divide s into n / k substrings, each with a length of k. Then, initialize result as an empty string.
 *
 * For each substring in order from the beginning:
 *
 * The hash value of a character is the index of that character in the English alphabet (e.g., 'a' → 0, 'b' → 1, ..., 'z' → 25).
 * Calculate the sum of all the hash values of the characters in the substring.
 * Find the remainder of this sum when divided by 26, which is called hashedChar.
 * Identify the character in the English lowercase alphabet that corresponds to hashedChar.
 * Append that character to the end of result.
 *
 * Return result.
 */

public class Solution {

    public String stringHash(String s, int k) {
        int index = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            sum += c - 'a';
            if (++index % k == 0) {
                sb.append((char) ('a' + (sum % 26)));
                sum = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        assert new Solution().stringHash("mxz", 3).equals("i");
    }

}
