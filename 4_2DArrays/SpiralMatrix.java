import java.util.*;

public class SpiralMatrix {
    public static List<Integer> printSpiral(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        List<Integer> list = new ArrayList<Integer>();

        while(startCol <= endRow && startRow <= endCol){
            for(int i=startRow; i<=endCol; i++)
               list.add(matrix[startCol][i]);
            startCol++;

            for(int i=startCol; i<=endRow; i++)
                list.add(matrix[i][endCol]);
            endCol--;

            if (startCol <= endRow){
                for(int i=endCol; i>=startRow; i--)
                    list.add(matrix[endRow][i]);
                endRow--;
            }

            if (startRow <= endCol){
                for(int i=endRow; i>=startCol; i--)
                    list.add(matrix[i][startRow]);
                startRow++;
            }
        }

        return list;
    }
    
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printSpiral(matrix1));
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(printSpiral(matrix2));
    }
}

/*
OUTPUT:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
1 2 3 6 9 8 7 4 5 
*/