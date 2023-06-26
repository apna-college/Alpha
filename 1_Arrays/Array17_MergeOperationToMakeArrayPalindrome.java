
public class Array17_MergeOperationToMakeArrayPalindrome {

    public static int mergeOperationNeed(int[] arr) {
        int leftPoint = 0, rightPoint = arr.length-1;
        int ans = 0;

        while(leftPoint <= rightPoint) {
            if(arr[leftPoint] == arr[rightPoint]) {
                leftPoint++;
                rightPoint--;
            } else if(arr[leftPoint] > arr[rightPoint]) {
                rightPoint--;
                arr[rightPoint] += arr[rightPoint+1];
                ans++;
            } else {
                leftPoint++;
                arr[leftPoint] += arr[leftPoint-1];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {15, 4, 15};
        int[] arr2 = {1, 4, 5, 1};
        int[] arr3 = {11, 14, 15, 99};
        int[] arr4 = {1, 4, 3, 3, 5, 1};
        int[] arr5 = {11, 14, 1, 1, 15, 99};

        System.out.println(mergeOperationNeed(arr5));
    }
}
