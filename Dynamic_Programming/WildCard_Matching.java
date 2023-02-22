// given 2 strings, one is string and second id pattern string. We have to create pattern string as a main string using pattern wild card operation. There are two wild card operation '?' and '*'.
// '?' do only replace and '*' can be any thing like empty string, many words combine string.

package Dynamic_Programming;

public class WildCard_Matching {
    public static void main(String[] args) {
        System.out.println(Wild_card_match("abc", "a?"));
    }

    public static boolean Wild_card_match(String s, String p) {
        int n = s.length();
        int m = p.length();
        // Step 1 - Table creation
        boolean dp[][] = new boolean[n+1][m+1];

        // Meaning assign --> for dp[i][j] means i length string and j length pattern here string can be match or not

        // Intialization
        dp[0][0] = true; // case 1 -> because both empty string then matched so true

        // case 2 -> pattern is empty and string can be anything except 0 then false because we can not try to match string because our pattern is 0

        // case 3 -> Have 2 sub cases that if char is '*' then check for previouses else false
        for (int j = 1; j < dp[0].length; j++) {
            if(p.charAt(j-1) == '*')    
            dp[0][j] = dp[0][j-1];

            else
            dp[0][j] = false;
        }

        //fill the table bottom to up
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]; 
                    // dp[i][j-1] means '*' is empty string and
                    // dp[i-1][j] means character matched and '*' can be used in later 
                }
                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
