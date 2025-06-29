package org.example.twoPointers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum
{
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(numsMap.containsKey(key)) {
                arr[0] = numsMap.get(key);
                arr[1] = i;
                break;
            }
            numsMap.put(nums[i], i);
        }
        return arr;
    }
    
    public static List<int[]> possibleTwoSums(int[] nums, int target) {
        
        return null;
    }
}
