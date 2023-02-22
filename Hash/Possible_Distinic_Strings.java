//Leetcode - 2306 - Naming a company

/* 
Choose 2 distinct names from ideas, call them ideaA and ideaB.
Swap the first letters of ideaA and ideaB with each other.
If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
Otherwise, it is not a valid name.
Return the number of distinct valid names for the company.
*/

package Hash;

import java.util.*;

class Possible_Distinic_Strings {
    public static long distinctNames(String[] ideas) {
        int n = ideas.length;

        HashSet<String>[] ig = new HashSet[26];

        for (int i = 0; i < 26; i++) {
            ig[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            ig[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long ans = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                int mutual = 0;
                for (String idea : ig[i]) {
                    if (ig[j].contains(idea))
                        mutual++;
                }

                ans += (ig[i].size() - mutual) * (ig[j].size() - mutual) * 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"coffe","donuts","time","toffe"}));
    }
}
