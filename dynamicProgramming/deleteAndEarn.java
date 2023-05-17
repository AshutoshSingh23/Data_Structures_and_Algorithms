package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class deleteAndEarn {

    List<Integer> list  = new ArrayList<>(); 

    public static int maxEarning(int[] nums, int i) {
        if (i < 0)
            return 0;
        if (nums[i] == 0)
            return maxEarning(nums, i - 1);
        int[] arr = new int[nums.length];
        for(int j=0;j<nums.length;j++)
            arr[j] = nums[j];
        System.out.println();
        System.out.println("ahkfdug  "+ arr[i]);
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == nums[i] - 1 || arr[j] == nums[i] + 1)
                arr[j] = 0;
            System.out.print(arr[j]);
        }
        System.out.println();
        return Math.max(nums[i] + maxEarning(arr, i - 1), maxEarning(nums, i - 1));
    }

    public static int deleteandEarn(int[] nums) {
        return maxEarning(nums, nums.length - 1);
    }
    
    public static void main(String[] args){
        int[] nums = {2,2,3,3,3,4};
        System.out.println(deleteandEarn(nums));
        for(int num:nums)
            System.out.println(num);
    }
}
