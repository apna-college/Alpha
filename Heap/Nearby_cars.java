package Heaps;

import java.util.PriorityQueue;

public class Nearby_cars {
    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int x = pts[i][0];
            int y = pts[i][1];
            int dis_sqr = (x*x) + (y*y) ;
            pq.add(new Point(x, y, dis_sqr, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("car no."+pq.remove().index);
        }
    }

    static class Point implements Comparable<Point>{
        int x ;
        int y;
        int dis_sqr ;
        int index ;

        public Point(int x,int y,int dis_sqr,int index){
            this.x = x ;
            this.y = y ;
            this.dis_sqr = dis_sqr ;
            this.index = index ;
        }

        @Override
        public int compareTo(Point p2){
            return this.dis_sqr - p2.dis_sqr ;
        }
    }
}
