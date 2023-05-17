package Microsoft;


public class nPositive {

    public static StringBuilder increment(StringBuilder sb, int i){
        int carry = 1;
        for(int j=i;j>-1;j--){
            int sum = carry + sb.charAt(j)-'0';
            carry = sum/10;
            sum = sum%10;
            sb.replace(j, j+1, Integer.toString(sum));
        }
        if(carry==1){
            StringBuilder st = new StringBuilder();
            st.append("1");
            st.append(sb);
            System.out.println(st + " " + sb);
            return st;
        }
        System.out.println(" ------------------ " + sb);
        return sb;
    }

    public static StringBuilder helper(StringBuilder sb, boolean bool){
        boolean nonrepeat = true;
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)==sb.charAt(i+1)){
                sb = increment(sb, i+1);
                for(int j=i+2;j<sb.length();j++){
                    sb.replace(j, j+1, Integer.toString(0));
                }
                nonrepeat = false;
                bool = true;                
                break;          
            }
            System.out.println(sb.charAt(i)+" ====== "+sb.charAt(i+1));
        }
        if(nonrepeat){
            if(!bool){
                sb = increment(sb, sb.length()-1);
                System.out.println("////////// "+sb);
                helper(sb,true);
            }else
                return sb;
        }
        System.out.println("////////// ************"+sb);
        return helper(sb,true);
    }
    public static void main(String[] args){
        int n = 98;
        StringBuilder sb = new StringBuilder(Integer.toString(n));   
        boolean bool = false;
        sb = helper(sb, bool);
        n = Integer.parseInt(sb.toString());
        System.out.println(sb);
    } 
}
