package com.carcinus.code.leetcode.p_2001_3000.p_2301_2400.p_2381_2390.p_2383;

/**
 * 2383. 赢得比赛需要的最少训练时长
 *
 * @link <a href="https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/">...</a>
 */
public class MinimumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;

        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                int gap = energy[i] - initialEnergy + 1;
                initialEnergy += gap;
                res += gap;
            }
            if (initialExperience <= experience[i]) {
                int gap = experience[i] - initialExperience + 1;
                initialExperience += gap;
                res += gap;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];

        }

        return res;
    }

    public static void main(String[] args) {
        MinimumHoursOfTrainingToWinACompetition object = new MinimumHoursOfTrainingToWinACompetition();
        System.out.println(object.minNumberOfHours(
                30,
                70,
                new int[]{24, 91, 63, 38, 31, 63, 22, 35, 91, 54, 88, 46, 80, 14, 12, 19, 57, 92},
                new int[]{18, 43, 36, 88, 84, 21, 82, 54, 61, 80, 68, 54, 75, 27, 99, 14, 86, 95}
        ));
    }
}
