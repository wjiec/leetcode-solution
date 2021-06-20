package weekly.w246.p1p5789thenumberoffullroundsyouhaveplayed;

/**
 * 5789. The Number of Full Rounds You Have Played
 *
 * https://leetcode-cn.com/contest/weekly-contest-246/problems/the-number-of-full-rounds-you-have-played/
 *
 * A new online video game has been released, and in this video game,
 * there are 15-minute rounds scheduled every quarter-hour period.
 * This means that at HH:00, HH:15, HH:30 and HH:45, a new round starts,
 * where HH represents an integer number from 00 to 23. A 24-hour clock is used,
 * so the earliest time in the day is 00:00 and the latest is 23:59.
 *
 * Given two strings startTime and finishTime in the format "HH:MM" representing
 * the exact time you started and finished playing the game, respectively,
 * calculate the number of full rounds that you played during your game session.
 *
 * For example, if startTime = "05:20" and finishTime = "05:59" this means you played only one
 * full round from 05:30 to 05:45. You did not play the full round from 05:15 to 05:30 because you
 * started after the round began, and you did not play the full round from 05:45 to 06:00 because you
 * stopped before the round ended.
 * If finishTime is earlier than startTime, this means you have played
 * overnight (from startTime to the midnight and from midnight to finishTime).
 *
 * Return the number of full rounds that you have played if you
 * had started playing at startTime and finished at finishTime.
 */

public class Solution {

    public int numberOfRounds(String startTime, String finishTime) {
        int[] start = splitTime(startTime), end = splitTime(finishTime);
        int startHH = start[0], startMM = start[1], endHH = end[0], endMM = end[1];
        if (endHH < startHH || (endHH == startHH && endMM < startMM)) {
            endHH += 24;
        }

        int s = startHH * 60 + startMM, e = endHH * 60 + endMM;
        if (s % 15 != 0) s += 15 - (s % 15);
        return (e - s) / 15;
    }

    private int[] splitTime(String time) {
        String[] times = time.split(":");

        return new int[]{Integer.valueOf(times[0], 10), Integer.valueOf(times[1], 10)};
    }

    public static void main(String[] args) {
        assert new Solution().numberOfRounds("12:01", "12:44") == 1;
        assert new Solution().numberOfRounds("20:00", "06:00") == 40;
        assert new Solution().numberOfRounds("00:00", "23:59") == 95;
    }

}
