// union and intersection of two numbers

package Hash;

import java.util.HashSet;

public class Union_and_Intersection {
    public static void main(String[] args) {
        int arr[] = {7,3,9};
        int arr2[]={6,3,9,2,9,4};

        Uni_and_Ins(arr, arr2);
    }

    public static void Uni_and_Ins(int arr[],int arr2[]){
        HashSet<Integer> hs = new HashSet<>();
       
        for(int i=0 ; i<arr.length ; i++){
            hs.add(arr[i]);
        }
        for(int i=0 ; i < arr2.length ; i++){
            if(!hs.contains(arr2[i]))
            hs.add(arr2[i]) ;
        }

        System.out.println("Union is" +hs);

        hs.clear();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        HashSet<Integer> hs2 = new HashSet<>();
        for(int i = 0 ; i < arr2.length ; i++){
            if(hs.contains(arr2[i])){
                hs2.add(arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        System.out.println("Inter section is "+hs2);
    }
}
