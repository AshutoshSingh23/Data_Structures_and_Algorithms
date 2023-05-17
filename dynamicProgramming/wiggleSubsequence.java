package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class wiggleSubsequence {
    public static boolean check(List<Integer> list) {
        if (list.size() <= 1)
            return true;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < list.size() - 1; i++) {
            st.push(list.get(i) - list.get(i + 1));
        }
        int i = st.pop();
        while (!st.isEmpty()) {
            if (i * st.peek() >= 0)
                return false;
            i = st.pop();
        }
        return true;
    }

    static int max = 1;

    /*public static int maxLength(int[] nums, int i, List<Integer> list) {
        if (i >= nums.length)
            return max = Math.max(list.size(), max);
        List<Integer> lis = new ArrayList<>();
            lis.addAll(list);
        if (lis.size() == 0) {
            int c = maxLength(nums, i + 1, lis);
            lis.add(nums[i]);
            int b = maxLength(nums, i + 1, lis);
            c = Math.max(c, b);
            System.out.println(lis + "   lfhlfh");
            return max = Math.max(max, c);
        } else if (lis.size() % 2 == 0) {
            if (lis.get(lis.size() - 1) > nums[i]) {
                int c = maxLength(nums, i + 1, lis);
                lis.add(nums[i]);
                int b = maxLength(nums, i + 1, lis);
                System.out.println(lis + "gyfligdigid");
                c = Math.max(c, b);
                return max = Math.max(max, c);
            } else {
                System.out.println(lis+" ydiuo");
                int c = maxLength(nums, i + 1, lis);
                return max = Math.max(c, max);
            }
        } else {
            if (lis.get(lis.size() - 1) < nums[i]) {
                int c = maxLength(nums, i + 1, lis);
                lis.add(nums[i]);
                int b = maxLength(nums, i + 1, lis);
                c = Math.max(c, b);
                System.out.println(lis + " khfkgfkgjlh");
                return max = Math.max(max, c);
            } else {
                System.out.println(lis+" gfiugfou");
                int c = maxLength(nums, i + 1, lis);
                return max = Math.max(c, max);
            }
        }

    }*/

    public static int maxLength2(int[] nums, int i, List<Integer> list) {
        if (i >= nums.length&&check(list))
            return max = Math.max(list.size(), max);
        List<Integer> lis = new ArrayList<>();
        lis.addAll(list);
        if (check(list)) {
            int c = maxLength2(nums, i + 1, lis);
            System.out.println(lis + " khfkgfkgjlh");
            if(!lis.isEmpty()&&lis.get(lis.size()-1)==nums[i])
                return max = Math.max(c,max);
            lis.add(nums[i]);
            int b = maxLength2(nums, i + 1, lis);
            System.out.println(lis + " ueg;roiye;riy");
            c = Math.max(c, b);
            return max = Math.max(max, c);
        } else {
            System.out.println(lis + " llqlkjfq");
            return max;
        }
    }

    public static int wiggleMaxLength(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        max = 1;
        return maxLength2(nums, 0, lis);
    }

    public static void main(String[] args){
        //int[] nums = {1,7,4,9,2,5};
        //int[] nums = {3,3,3,2,5};
        int[] nums = {0,0};
        System.out.println(wiggleMaxLength(nums));
    }
}
