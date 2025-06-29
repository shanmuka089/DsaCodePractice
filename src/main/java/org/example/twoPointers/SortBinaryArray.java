package org.example.twoPointers;

public class SortBinaryArray
{
    
    public static void sortBinaryArray(int[] nums) {
        
        int left = 0, right = nums.length-1;
        
        while(left < right) {
            
            if(nums[left] == 0 && nums[right] == 1) {
                left++;
                right--;
            } else if(nums[left] == 1 && nums[right] == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if(nums[left] == 1 && nums[right] == 1) {
                right--;
            } else {
                left++;
            }
        }
    }
}
