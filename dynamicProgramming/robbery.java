package dynamicProgramming;

public class robbery {

    public static int robCh(int[] nums, int sum, int i, int k, boolean b) {
        if (k == 0)
            return sum;
        if (i < 0)
            return 0;
        if(b){
            if(i==0||i==nums.length-1)
                return robCh(nums, sum, i - 1, k, b);
        }
        boolean f=false,g=(i==nums.length-1||i==0);

        return Math.max(robCh(nums, sum + nums[i], i - 2, k - 1,g), robCh(nums, sum, i - 1, k,f));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length % 2 == 0) {
            int s = 0, u = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0)
                    s += nums[i];
                else
                    u += nums[i];
            }
            return Math.max(s, u);
        }
        int k = nums.length / 2;
        return robCh(nums, 0, nums.length - 1, k,true);
    }
    
    public static void main(String[] args){
        //int[] nums = {6,3,10,8,2,10,3,5,10,5,3};
        int [] nums = {2,3,2};
        System.out.println(rob(nums));
    }
}
