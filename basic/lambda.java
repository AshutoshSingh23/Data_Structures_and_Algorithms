public class lambda {

    public interface k{
        int show(int i);
    }

    public static void main(String[] args){
        int n = 90;
    
        k h = (int i) -> {
            System.out.println(i);
            if(i<100)
                return 1;
            else 
                return 0;
        };

        System.out.println(h.show(n));
    }
    
}
