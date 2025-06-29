package org.example.twoPointers;

public class SortColors
{

    public static void sortColors(int[] nums) {
        
        /*
        * Red -> 0
        * White -> 1
        * Blue -> 2
        * */
        
        int low = 0, mid = 0, high = nums.length-1;
        
        while(mid <= high) {
            
            if(nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
