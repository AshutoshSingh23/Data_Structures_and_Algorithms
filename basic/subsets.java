import java.util.ArrayList;
import java.util.List;

public class subsets {
    
    static List<List<Integer>> list = new ArrayList<>();

    public static void subset(List<Integer> lst, int i) {
        if (i < 0) {
            list.add(lst);
            for (int f : lst) {
                System.out.println(" ///////////// "+f+" ////////////// ");
            }
            System.out.println(" ///////////// " + "qwerty" +" ////////////// ");
            return;
        }
        
        System.out.println("============");
        for(int f:lst){
            System.out.println(f);
        }
        System.out.println("------------");
        
        List<Integer> lis = new ArrayList<>();
        subset(lst, i - 1);
        int c = lst.remove(i);
        lis.addAll(lst);
        subset(lis, i - 1);
        lst.add(i,c);
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        list.add(new ArrayList<>());
        if (nums.length == 0)
            return list;
        if (nums.length == 1) {
            lis.add(nums[0]);
            list.add(lis);
            return list;
        }

        list.remove(0);
        for (int i=0;i<nums.length;i++) {
            lis.add(nums[i]);
            System.out.println(lis.get(i)+" "+lis.size());
        }
        subset(lis, lis.size() - 1);
        return list;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> k = subsets1(nums);
        for(List<Integer> i:k){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
