package Graphs;
// refer statement of Leetcode 909

import java.util.LinkedList;
import java.util.Queue;

public class Snakes_and_Ladders {
    public static void main(String[] args) {
        int board[][] = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][n];

        q.add(1);
        vis[n-1][0] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i < size ; i++){
                int curr = q.remove();
                if(curr == n*n) return steps;

                for(int k=1; k<=6 ;k++){
                    if(k+curr > n*n) break;
                    int pos[] = findCordinates(k+curr , n);
                    int r = pos[0];
                    int c = pos[1];

                    if(vis[r][c]) continue;

                    vis[r][c] = true;

                    if(board[r][c] == -1)
                    q.add(k + curr);
                    else
                    q.add(board[r][c]);
                }
            }
            steps++;
        }

        return -1;
    }

    public static int[] findCordinates(int curr,int n){
        int r = n - (curr-1)/n-1;
        int c = (curr-1) % n ;

        return r%2==n%2 ? new int[]{r,n-1-c} : new int[]{r,c};
    }
}