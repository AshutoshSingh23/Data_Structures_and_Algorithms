package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nearestGreatLeft {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 1, 3, 0, 7, 2, 4 };
        Stack<Integer> stk = new Stack<>();
        List<Integer> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                st.add(-1);
            } else if (stk.peek() > arr[i]) {
                st.add(stk.peek());
            } else {
                stk.pop();
                i--;
                continue;
            }
            stk.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(st.get(i) + " ");
        System.out.println();
    }
}
