package org.example.twoPointers;

public class MaxConsecutiveOnes
{
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 1) {
                count++;
            } else {
                maxConsecutive = Math.max(count, maxConsecutive);
                count = 0;
            }
        }
        return Math.max(count, maxConsecutive);
    }
}
