/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100
 */

 import java.util.ArrayList;
public class Array25_SpiralMatrix {

    public static void spiralPrint(int[][] arr) {
        int startRow = 0, startColumn = 0, endRow = arr.length-1, endColumn = arr[0].length-1;

        while(startRow <= endRow && startColumn <= endColumn) {
                //top boundary
            for(int j = startColumn; j <= endColumn; j++) {
                System.out.print(arr[startRow][j]+" ");
            }
                //right boundary
            for(int i = startRow+1; i <= endRow; i++) {
                System.out.print(arr[i][endColumn]+" ");
            }
            //bottom Boundary
            for(int j = endColumn-1; j >= startColumn; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(arr[endRow][j]+" ");
            }
            //left boundary
            for(int i = endRow-1; i >= startRow+1; i--) {
                if(endColumn == endRow) {
                    break;
                }
                System.out.print(arr[i][startColumn]+" ");
            }

            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }

    }

    public static void main(String[] args) {
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralPrint(arr2);
        
    }
}
