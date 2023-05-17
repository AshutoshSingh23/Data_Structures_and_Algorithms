import java.util.LinkedList;
import java.util.List;

public class countSmallerAfterSelf {
    
    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> list = new LinkedList<>();
        int i=0,j=0;
        while(i<a.size()||j<b.size()){
            System.out.println(i +" "+ j);
            if(i==a.size()){
                list.add(b.get(j));
                j++;
                continue;
            }
            if(j==b.size()){
                list.add(a.get(i));
                i++;
                continue;
            }
            if(a.get(i)<b.get(j)){
                list.add(a.get(i));
                i++;
            }
            else{
                list.add(b.get(j));
                j++;
            }
        }
        return list;
    }
    
    public static List<Integer> mergeSort(List<Integer> lis){
        if(lis.size()==1)
            return lis;
        int s=0,f=lis.size()-1;
        int mid = s + (f-s)/2;
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        s--;
        while(++s<=mid)
            a.add(lis.get(s));
        while(mid++<f)
            b.add(lis.get(mid));
        System.out.println(a);
        System.out.println(b);    
        a = mergeSort(a);
        b = mergeSort(b);
        lis = merge(a,b);
        return lis;
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i:nums)
            list.add(i);
        list = mergeSort(list);
        System.out.println(list);
        return list;
    }

    public static void main(String[] args){
        int[] nums = {5,2,2,6,1};
        countSmaller(nums);  
    }
}
