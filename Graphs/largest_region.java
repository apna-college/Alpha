// assignment(1) - 4 

package Graphs;

public class largest_region {
    public static int row,col,count ;
    
    public static int largestRegion(int m[][]){
        boolean vis[][]  = new boolean[row][col];
        int result = 0 ;
        row =4 ;
        col = 5;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(m[i][j] == 1 && !vis[i][j]){
                    count = 1 ;
                    dfs(m, vis, i, j);
                    result = Math.max(result,count);
                }
            }
        }
        return result;
    }

    public static void dfs(int m[][],boolean vis[][],int r,int c){

        // for find the neighbour of any element in matrix
        int rowNbr[] = {-1,-1,-1,0,0,1,1,1};
        int colNbr[] = {-1,0,1,-1,1,-1,0,1};

        vis[r][c] = true ;

        for(int k=0;k<8;k++){ 
            if(isSafe(m,vis , r+rowNbr[k], c+colNbr[k])){
                count++;
                dfs(m, vis, r+rowNbr[k], c+colNbr[k]);
            }
        }
    }

    
    public static boolean isSafe(int m[][],boolean vis[][],int i,int j){
        return (i >= 0) && (i < row) && (j >= 0) && (j < col) && (m[i][j] == 1 && !vis[i][j] );
    }



    public static void main(String[] args) {
        int m[][] = { { 0, 0, 1, 1, 0 },
                      { 1, 0, 1, 1, 0 },
                      { 0, 1, 0, 0, 0 },
                      { 0, 0, 0, 0, 1 } };
        row = 4;
        col = 5;
 
        // Function call
        System.out.println(largestRegion(m));
    }

}
