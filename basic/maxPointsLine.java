import java.util.HashMap;
import java.util.Map;

public class maxPointsLine {

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1 || n == 0)
            return n;
        Map<Integer, Integer> map = new HashMap<>();
        int m = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int x = points[i][0], y = points[i][1];
            for (int j = 1; j < n; j++) {
                int x1 = points[j][0], y1 = points[j][1];
                if(y==y1&&x==x1){
                    continue;
                }else if(y==y1){
                    m = 0;
                }else if(x == x1){
                    m = (int)Double.MAX_VALUE;
                }else{
                    m =  (y - y1) / (x - x1);
                }
                System.out.println(m+""+i+""+j);
                if (map.containsKey(m)) {
                    map.replace(m, map.get(m) + 1);
                } else {
                    map.put(m, 2);
                }
                max = Math.max(max, map.get(m));
            }
            map.clear();
        }
        return max;
    }

    public static void main(String[] args){
        int[][] points = {{2,3},{3,3},{-5,3}};
        System.out.println(maxPoints(points));
    }
    
}
