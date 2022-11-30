import java.util.PriorityQueue;

public class NearbyCars {
    /* We are given N points in a 2D plane which are locations of N cars. if we are at the 
     * origin , print the nearest K cars.
     * --> C0 (3,3)                                       3^2 + 3^2 = 18
     * --> C1 (5,-1)    if k = 2    ans = C0 & C2         5^2 + (-1)^2 = 26
     * --> C2 (-2,4)                                      -2^2 + 4^2 = 20
     */
    static class Point implements Comparable<Point>{
        int x,y,distSq,idx;  // Actually here is no need of x & y.
        public Point(int x,int y,int distSq,int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        //nearest k cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }
}
