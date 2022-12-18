package practice.leetcode;

public class ReachDest {

    public static void main(String[] args) {
        System.out.println(reachDestination(1 ,1, 2, 2));
    }
        public static boolean reachDestination(int sx, int sy, int dx, int dy) {
            // Destination reached
            if(sx == dx && sy == dy)
                return true;
            if(sx > dx || sy > dy)
                return false;
            return reachDestination(sx,sx+sy,dx,dy) || reachDestination(sx+sy, sy, dx,dy);
        }


}
