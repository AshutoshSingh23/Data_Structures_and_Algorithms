import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class foobar_2 {
    public static long mul(List<Integer> list) {
        long l = 1;
        for (int i = 0; i < list.size(); i++) {
            l *= (long) list.get(i);
        }
        return l;
    }

    public static String solution(int[] xs) {
        String s = "";
        List<Integer> list = new ArrayList<>();
        int count = 0, count1 = 0, min = 0;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] == 1) {
                count1++;
                continue;
            }
            if (xs[i] == 0) {
                continue;
            }
            list.add(xs[i]);
            if (xs[i] < 0) {
                count++;
                min = i;
            }
        }
        if (list.isEmpty()) {
            if (count1 != 0) {
                s = "1";
                return s;
            } else {
                s = "0";
                return s;
            }
        }
        if (list.size() == 1) {
            return String.valueOf(list.get(0));
        }
        if (list.size() == xs.length) {
            if (count % 2 == 0) {
                Collections.sort(list);
                if (list.size() == count) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    long l = mul(list);
                    return String.valueOf(l);
                }
                int a = 0, b = 1, c = 0;
                for (int i = 0; i < xs.length; i++) {
                    if (list.get(i) > 0) {
                        c = i;
                        break;
                    }
                }
                if (list.get(c) > list.get(a) * list.get(b)) {
                    list.remove(c - 1);
                    list.remove(c - 2);
                } else {
                    list.remove(c);
                }
                long l = mul(list);
                return String.valueOf(l);
            } else {

                for (int i = 0; i < list.size(); i++) {
                    if (xs[min] < xs[i] && xs[i] < 0) {
                        min = i;
                    }
                }
                list.remove(min);
                long l = mul(list);
                return String.valueOf(l);
            }
        } else {
            if (count % 2 != 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (xs[min] < xs[i] && xs[i] < 0) {
                        min = i;
                    }
                }
                list.remove(min);
            }
            long l = mul(list);
            return String.valueOf(l);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++)
            nums[i] = sc.nextInt();

        sc.close();
        String s = solution(nums);
        System.out.println(s);
    }
}