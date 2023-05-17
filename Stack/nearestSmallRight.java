package Stack;

import java.util.Stack;

public class nearestSmallRight {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 1, 3, 0, 7, 2, 4 };
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                st.push(-1);
            } else if (stk.peek() < arr[i]) {
                st.push(stk.peek());
            } else {
                stk.pop();
                i++;
                continue;
            }
            stk.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(st.pop() + " ");
        System.out.println();
    }
}
