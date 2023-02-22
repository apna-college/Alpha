package Hash;

import java.util.HashMap;

public class Journey_from_tickets {
    public static void main(String[] args) { // O(n)
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("chennai", "ahmedabad");
        tickets.put("ahmedabad", "mehsana");
        tickets.put("mehsana", "bhabhar");
        tickets.put("bengluru", "chennai");

        String start = findStart(tickets);
        System.out.print(start);

        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start) ;
        }

        System.out.println();
    }

    public static String findStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) 
            revMap.put(tickets.get(key), key); // reverse the tickets map

        for (String key  : tickets.keySet()) {
            if(!revMap.containsKey(key))
            return key ;
        }

        return null ; // this just for return string baki avi condition kdi nahi ave
    }
}
