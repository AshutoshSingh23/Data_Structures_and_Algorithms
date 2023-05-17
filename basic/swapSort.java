public class swapSort {
    
    public static void swapS(int[] arr){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                if(arr[i]==arr[arr[i]-1]){
                    i++;
                }else{
                    int y = arr[i] - 1;
                    int swap = arr[i];
                    arr[i] = arr[y];
                    arr[y] = swap;
                }
                continue;
            }

            i++;
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                System.out.println("Duplicate:"+arr[j]+" Missing:"+(j+1));
            }
        }
    }
    public static void main(String[] args){
        int arr[] = {1,4,5,2,3,3,2};
        swapS(arr);
    }
}
