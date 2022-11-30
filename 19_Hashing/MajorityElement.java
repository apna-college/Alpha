import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    //Given an integer array of size n, find all element that appear more than n/3 time.
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};
        // Ans - 1     || n = 9  , 9/3 = 3 and only 1 is appearing more than 3 times.
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }
}