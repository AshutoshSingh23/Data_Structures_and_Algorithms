import java.util.*;

public class asjdg {
    public static void main(String[] args){
        String[] cities = {"Bangalore","Pune","San Francisco","New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities,ms);
        for(String str:cities){
            System.out.println(str);
        }
        System.out.println(Arrays.binarySearch(cities, "New York City"));
    }

    static class MySort implements Comparator<String>{
        public int compare(String a, String b){
            return b.compareTo(a);
        }
    }
}
