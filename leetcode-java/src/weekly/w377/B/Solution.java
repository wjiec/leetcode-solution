package weekly.w377.B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2975. Maximum Square Area by Removing Fences From a Field
 *
 * https://leetcode.cn/contest/weekly-contest-377/problems/maximum-square-area-by-removing-fences-from-a-field/
 *
 * There is a large (m - 1) x (n - 1) rectangular field with corners at (1, 1) and (m, n) containing
 * some horizontal and vertical fences given in arrays hFences and vFences respectively.
 *
 * Horizontal fences are from the coordinates (hFences[i], 1) to (hFences[i], n) and vertical
 * fences are from the coordinates (1, vFences[i]) to (m, vFences[i]).
 *
 * Return the maximum area of a square field that can be formed by removing some
 * fences (possibly none) or -1 if it is impossible to make a square field.
 *
 * Since the answer may be large, return it modulo 109 + 7.
 *
 * Note: The field is surrounded by two horizontal fences from the
 * coordinates (1, 1) to (1, n) and (m, 1) to (m, n) and two vertical
 * fences from the coordinates (1, 1) to (m, 1) and (1, n) to (m, n).
 *
 * These fences cannot be removed.
 */

public class Solution {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2]; h[0] = 1; h[h.length - 1] = m;
        System.arraycopy(hFences, 0, h, 1, hFences.length);
        Arrays.sort(h);

        int[] v = new int[vFences.length + 2]; v[0] = 1; v[v.length - 1] = n;
        System.arraycopy(vFences, 0, v, 1, vFences.length);
        Arrays.sort(v);

        Set<Integer> dist = new HashSet<>();
        for (int l = 0; l < v.length; l++) {
            for (int r = l + 1; r < v.length; r++) {
                dist.add(v[r] - v[l]);
            }
        }

        long area = -1;
        for (int l = 0; l < h.length; l++) {
            for (int r = h.length - 1; r > l; r--) {
                int len = h[r] - h[l];
                if (check(v, len)) {
                    area = Math.max(area, (long) len * len);
                    break;
                }
            }
        }

        return (int) (area < 0 ? -1 : (area % 1_000_000_007));
    }

    private boolean check(int[] fences, int len) {
        for (var v : fences) {
            if (v > len && Arrays.binarySearch(fences, v - len) > 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        assert new Solution().maximizeSquareArea(4, 3, new int[]{2,3}, new int[]{2}) == 4;
        assert new Solution().maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}) == -1;
    }

}
