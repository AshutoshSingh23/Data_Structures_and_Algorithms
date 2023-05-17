package Stack;

import java.util.Stack;

public class nearestGreatRight {
    
    public static void main(String[] args){
        int n = 6;
        int[] arr = {1,3,0,7,2,4};
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> st = new Stack<>();
        //System.out.println(stk.isEmpty());
        for(int i=n-1;i>=0;i--){
            if(stk.isEmpty()){
                st.push(-1);
                //System.out.println("===" + st.peek() + "===");
            }
            else if(stk.peek()>arr[i]){
                st.push(stk.peek());
                //System.out.println("///"+stk.peek()+"///");
                //System.out.println("===" + st.peek() + "===");
            }else{
                stk.pop();
                i++;
                continue;
                /*while(!stk.isEmpty()){
                    if(stk.peek()>arr[i])
                        break;
                    stk.pop();
                }if(stk.isEmpty())
                    st.push(-1);
                else
                    st.push(stk.peek());*/
                //System.out.println("===" + st.peek() + "===");
            }
            stk.push(arr[i]);
            //System.out.println(stk.peek());
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(st.pop()+" ");
        System.out.println();   
    }
}
