import java.util.*;

public class check {
    public static int maxSquare(int number, int start, int end) {
        int mid = (start + end) / 2;
        int mid2 = mid * mid;

        if (end - start == 1 || start - end == 1) {
            if ((mid + 1) * (mid + 1) <= number)
                return (mid + 1) * (mid + 1);
            else
                return mid2;
        } else {
            if (mid2 < number)
                return maxSquare(number, mid, end);
            else if (mid2 > number)
                return maxSquare(number, start, mid);
            else if (mid2 == number) {
                return mid2;
            }
        }

        return 0;
    }

    public static int[] answer(int area) {

        List<Integer> result = new ArrayList<Integer>();
        while (area > 0) {
            int next = maxSquare(area, 1, 1000);
            result.add(next);
            area -= next;
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);

        return answer;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] nums = answer(n);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}