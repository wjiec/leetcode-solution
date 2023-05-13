package lcp.p78;

/**
 * LCP 78. 城墙防线
 *
 * https://leetcode.cn/problems/Nsibyl/
 *
 * 在探险营地间，小扣意外发现了一片城墙遗迹，在探索期间，却不巧遇到迁徙中的兽群向他迎面冲来。
 * 情急之下小扣吹响了他的苍蓝笛，随着笛声响起，遗迹中的城墙逐渐发生了横向膨胀。
 *
 * 已知 rampart[i] = [x,y] 表示第 i 段城墙的初始所在区间。当城墙发生膨胀时，将遵循以下规则：
 *
 * 所有的城墙会同时膨胀相等的长度；
 * 每个城墙可以向左、向右或向两个方向膨胀。
 * 小扣为了确保自身的安全，需要在所有城墙均无重叠的情况下，让城墙尽可能的膨胀。请返回城墙可以膨胀的 最大值 。
 *
 * 注意：
 *
 * 初始情况下，所有城墙均不重叠，且 rampart 中的元素升序排列；
 * 两侧的城墙可以向外无限膨胀。
 */

public class Solution {

    public int rampartDefensiveLine(int[][] rampart) {
        int l = 0, r = (int) 10e8 + 100, ans = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(rampart, mid)) {
                ans = mid; l = mid + 1;
            } else r = mid;
        }
        return ans;
    }

    private boolean check(int[][] rampart, int v) {
        int prevUsed = 0, n = rampart.length;
        for (int i = 1; i < n; i++) {
            int pGap = rampart[i][0] - rampart[i - 1][1] - prevUsed;
            int nGap = (i + 1 == n ? Integer.MAX_VALUE : rampart[i + 1][0]) - rampart[i][1];
            if (pGap + nGap < v) return false;
            prevUsed = Math.max(0, v - pGap);
        }
        return true;
    }

    public static void main(String[] args) {
        assert new Solution().rampartDefensiveLine(new int[][]{{0,3},{4,5},{7,9}}) == 3;
        assert new Solution().rampartDefensiveLine(new int[][]{{1,2},{5,8},{11,15},{18,25}}) == 4;
    }

}
