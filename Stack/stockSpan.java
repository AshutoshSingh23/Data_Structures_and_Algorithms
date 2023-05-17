package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        List<Integer> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                st.add(1);
            } else if (stk.peek() > arr[i]) {
                st.add(i - ind.peek());
            } else {
                stk.pop();
                ind.pop();
                i--;
                continue;
            }
            stk.push(arr[i]);
            ind.push(i);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(st.get(i) + " ");
        System.out.println();
    }
}
