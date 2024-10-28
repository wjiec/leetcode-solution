package weekly.bw142.A;

/**
 * 3330. Find the Original Typed String I
 *
 * https://leetcode.cn/contest/biweekly-contest-142/problems/find-the-original-typed-string-i/
 *
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy
 * and may press a key for too long, resulting in a character being typed multiple times.
 *
 * Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
 *
 * You are given a string word, which represents the final output displayed on Alice's screen.
 *
 * Return the total number of possible original strings that Alice might have intended to type.
 */

public class Solution {

    public int possibleStringCount(String word) {
        int ans = 1, curr = 1; char prev = ' ';
        for (var c : word.toCharArray()) {
            if (c != prev) {
                if (curr > 1) ans += curr - 1;
                curr = 1; prev = c;
            } else curr++;
        }
        return ans + curr - 1;
    }

    public static void main(String[] args) {
    }

}
