package Heaps;

import java.util.PriorityQueue;

public class Weakest_Soldier {
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};

        PriorityQueue<detail> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0 ;
            for (int j = 0; j < army[0].length; j++) { // for count the sum of every row
                count += army[i][j] == 1 ? 1 : 0 ;
            }
            pq.add(new detail(i, count));
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(pq.remove().index);
        }
    }

    static class detail implements Comparable<detail>{
        int index ;
        int soldier ;
        public detail(int index,int soldier){
            this.index  = index ;
            this.soldier = soldier ;
        }

        @Override
        public int compareTo(detail d2){
            if(this.soldier == d2.soldier)
            return this.index - d2.index ;

            else
            return this.soldier - d2.soldier ;
        }
    }
}
