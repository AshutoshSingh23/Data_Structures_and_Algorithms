package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class dp_equals {
    public static boolean equalArray(List<Integer> arr) {
        int count = 0;
        for (int i : arr) {
            if (arr.get(0) == i)
                count++;
        }
        if (count == arr.size())
            return true;
        return false;
    }

    public static boolean posArray(List<Integer> arr) {
        for (int i : arr) {
            if (i < 0)
                return false;
        }
        return true;
    }

    public static int minCount(int sum, int[] memo) {
        int count = 1;
        int min = Integer.MAX_VALUE;
        if(sum == 0){
            return 0;
        }
        if(sum<0){
            return -1;
        }
        if(memo[sum]!=0)
            return memo[sum];
        int[] arr = {1,2,5};
        for(int i=0;i<3;i++){
            int c = minCount(sum-arr[i],memo);
            if(c>=0)
                min = Math.min(min,c);
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        count += min; 
        return memo[sum] = count;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(7);

        int min = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(min)>list.get(i))
                min = i;
        }
        min = list.get(min);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i)-min);
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            if(min-i<0)
                break;
            for(int j=0;j<list.size();j++){
                if (list.get(j) >= 0)
                    list.set(j, list.get(j) + i);

                int[] memo = new int[list.get(j) + 1];
                sum += minCount(list.get(j), memo);
            }
            minCount = Math.min(sum, minCount);
        }
        System.out.println(minCount);
    }
}
