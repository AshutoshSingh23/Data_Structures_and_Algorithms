package Stack;

import java.util.Stack;

public class removingIndexI {

    public static Stack<Integer> removeInd(int m,Stack<Integer> stk){
        if(m == 0)  return stk;
        int c=0;
        if(m!=1)
            c = stk.pop();
        else
            stk.pop();
        stk = removeInd(m-1, stk);
        if (m != 1)
            stk.push(c);
        return stk;
    }

    public static void main(String[] args){
        int ind = 3;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<10;i++){
            stk.push(i);
        }
        int m = stk.size()-ind;
        removeInd(m, stk);
        for(int i:stk){
            System.out.println(i);
        }
    }
    
}
