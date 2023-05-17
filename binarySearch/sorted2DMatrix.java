package binarySearch;

public class sorted2DMatrix {

    public static void matrixSearch(int[][] t, int m){
        int i = 0, j = 3;
        while(i<4&&j<4){
            if(m == t[i][j])
                break;
            else if(m>t[i][j])
                i++;
            else
                j--;
        }
        System.out.println(i + " " + j);
    }
    

    public static void main(String[] args) {
        int[][] arr = { {10,20,30,40},{11,23,32,45},{15,25,35,46},{19,28,39,50} };
        int m = 35;
        matrixSearch(arr, m);
    }
}
