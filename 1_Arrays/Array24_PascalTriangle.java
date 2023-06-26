/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:

    1 <= numRows <= 30


 */

import java.util.ArrayList;
public class Array24_PascalTriangle {

    public static void printPascalTriangle(int rowNum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> listN = new ArrayList<>();

        for(int i = 0; i < rowNum; i++) {
            ArrayList<Integer> inside = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    inside.add(j, 1);
                } else {
                    inside.add(j, listN.get(j)+listN.get(j-1));
                }
            }
            listN = inside;
            list.add(i,listN);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        printPascalTriangle(5);
    }
}
