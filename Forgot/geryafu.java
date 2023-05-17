import java.util.Scanner;
import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class geryafu {

    public static BigInteger mul(List<Integer> list) {
        BigInteger big = new BigInteger("1");
        for (int i = 0; i < list.size(); i++) {
            BigInteger next = new BigInteger(Integer.toString(list.get(i)));
            big = big.multiply(next);
        }
        return big;
    }

    public static String solution(int[] xs) {
        if (xs.length == 1)
            return Integer.toString(xs[0]);
        List<Integer> pos_list = new ArrayList<>();
        List<Integer> neg_list = new ArrayList<>();
        int count = 0;
        BigInteger big;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > 0)
                pos_list.add(xs[i]);
            else if (xs[i] < 0)
                neg_list.add(xs[i]);
            else
                count++;
        }
        if (count == xs.length) {
            return "0";
        }
        int h = pos_list.size() + neg_list.size();
        if (h == xs.length) {
            if (neg_list.isEmpty()) {
                Collections.sort(pos_list);
                pos_list.remove(0);
                big = mul(pos_list);
                return big.toString();
            }
            if (neg_list.size() % 2 == 0) {
                Collections.sort(neg_list);
                if (pos_list.isEmpty()) {
                    neg_list.remove(neg_list.size() - 1);
                    neg_list.remove(neg_list.size() - 1);
                    big = mul(neg_list);
                    return big.toString();
                }
                Collections.sort(pos_list);
                if (neg_list.get(neg_list.size() - 1) * neg_list.get(neg_list.size() - 2) < pos_list.get(0)) {
                    neg_list.remove(neg_list.size() - 1);
                    neg_list.remove(neg_list.size() - 1);
                    big = mul(neg_list).multiply(mul(pos_list));
                    return big.toString();
                } else {
                    pos_list.remove(0);
                    big = mul(neg_list).multiply(mul(pos_list));
                    return big.toString();
                }
            } else {
                Collections.sort(neg_list);
                neg_list.remove(neg_list.size() - 1);
                big = mul(neg_list).multiply(mul(pos_list));
                return big.toString();
            }
        } else {
            if (neg_list.size() % 2 == 0) {
                big = mul(neg_list).multiply(mul(pos_list));
                return big.toString();
            } else {
                if (pos_list.isEmpty() && neg_list.size() == 1) {
                    return "0";
                }
                Collections.sort(neg_list);
                neg_list.remove(neg_list.size() - 1);
                big = mul(neg_list).multiply(mul(pos_list));
                return big.toString();
            }
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