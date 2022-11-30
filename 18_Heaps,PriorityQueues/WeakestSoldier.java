import java.util.PriorityQueue;

public class WeakestSoldier {
    /* We are given an M*N binary matrix of 1's (Soldiers) and 0's (Civilians).
     * The Soldiers are positioned in front of the civilians. That is all the 1's
     * will appear to the left of all the 0's in each row.
     * 
     * A row i is weaker than a row j if one of the following is true
     *  - The number of Soldier in row i is less than the number of Soldier in j.
     *  - Both rows have the same numbers of Soldier and i < j.
     * Find the K weakest rows.
     */
    static class Row implements Comparable<Row>{
        int Soldiers;
        int idx;

        public Row(int Soldiers,int idx){
            this.Soldiers = Soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.Soldiers == r2.Soldiers){
                return this.idx - r2.idx;
            }else{
                return this.Soldiers - r2.Soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1:0;
            }
            pq.add(new Row(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
