package lcp.p30;

import java.util.PriorityQueue;

/**
 * LCP 30. 魔塔游戏
 *
 * https://leetcode.cn/problems/p0NxJO/
 *
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，
 * 其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 *
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，
 * 小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。
 *
 * 请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 */

public class Solution {

    public int magicTower(int[] nums) {
        long total = 1;
        for (var v : nums) total += v;
        if (total <= 0) return -1;

        long curr = 1, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (var v : nums) {
            if (v < 0) {
                pq.add(v);
                if (curr + v <= 0) {
                    ans++;
                    curr += -pq.remove();
                }
            }
            curr += v;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        assert new Solution().magicTower(new int[]{100,100,100,-250,-60,-140,-50,-50,100,150}) == 1;
        assert new Solution().magicTower(new int[]{-200,-300,400,0}) == -1;
    }

}
