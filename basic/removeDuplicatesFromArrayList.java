import java.util.ArrayList;

public class removeDuplicatesFromArrayList{
    public static int removeDuplicates(ArrayList<Integer> a) {
        int i=0,j=0;
        while(j<a.size()){
            if(a.get(i).equals(a.get(j))){
                if(j==i||j==i+1)
                j++;
                else{
                    a.remove(j);
                    continue;
                }
            }else{
                System.out.println(a.get(i) + " " + a.get(j));
                i=j;
                j++;
            }
        }
        return a.size();
	}

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        if(a.get(0)==a.get(1))
            System.out.println("**********");
        else
            System.out.println("++++++++++++");
        System.out.println(removeDuplicates(a) + " " + a);
    } 
}
