public class permutationSpaces {
    

    public static void spacePer(String s, int i) {
        if (i <= 0) {
            System.out.println(s);
            return;
        }

        spacePer(s, i - 1);
        s = s.substring(0,i) + " " + s.substring(i);
        spacePer(s, i - 1);
    }

    /*public static String subsets1(String s) {
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
        for (int i = 0; i < nums.length; i++) {
            lis.add(nums[i]);
            System.out.println(lis.get(i) + " " + lis.size());
        }
        subset(lis, lis.size() - 1);
        return list;
    }*/

    public static void main(String[] args) {
        String s = "acegdh";
        spacePer(s, s.length()-1);
    }
}
