
public class Array27_DiagonalSum {

    public static int diagonalSum(int[][] arr) {
        int n = arr.length;
        int sum = 0;
        /*for(int i = 0, j = 0; i < n; i++,j++) {
            sum += arr[i][j];
        }

        for(int i = 0, j = n-1; i < n; i++,j--) {
            sum += arr[i][j];
        }

        System.out.println(sum);*/
        for(int i = 0; i < n; i++) {
            sum += arr[i][i];

            if(i != n-1-i) {
                sum += arr[i][n-1-i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{3,4}};
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println(diagonalSum(arr2));
    }
}
