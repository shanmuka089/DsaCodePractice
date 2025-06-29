package org.example.twoPointers;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum
{
    
    public static List<List<Integer>> threeSum(int[] nums) {

        /*
        * Sorting will help to skip the duplicates.
        * if we want to do threeSum without sorting then we have to remove duplicates first.
        * */
        Arrays.sort(nums);

        List<List<Integer>> resultant = new ArrayList<>();

        for(int i = 0; i < nums.length-1; i++) {

            // skip iteration to avoid duplicate processing
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;

            int right = nums.length-1;

            /*
            * if three sum value is
            *   nums[i] + nums[left] + nums[right] = 0
            *   nums[left] + nums[right] = -nums[i]
            * */
            
            int target = -nums[i];

            while(left < right) {

                int sum = nums[left] + nums[right];

                if(sum == target) {
                    List<Integer> solList = Arrays.asList(nums[i], nums[left], nums[right]);
                    resultant.add(solList);
                    
                    // skipping the duplicate left & right elements to avoid duplicate processing.
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resultant;
    }
    
    
    public static Set<List<Integer>> unsortedThreeSum(int[] nums) {
        
        Set<List<Integer>> resultant = new HashSet<>();
        
        for(int i = 0; i < nums.length-2; i++) {
            
            Set<Integer> see = new HashSet<>();
            
            for(int j = i+1; j < nums.length; j++) {
                
                int complement = -(nums[i] + nums[j]);
                
                if(see.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    triplet.sort(null);
                    resultant.add(triplet);
                }
                see.add(nums[j]);
            }
        }
        return resultant;
    }
    
    
    
}
