class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p);
    }

    public static boolean dfs(int i, int j, String s, String p){
        int sLength = s.length();
        int pLength = p.length();
        // If both pointers reach the end, strings match
        if(i>=sLength && j>= pLength) return true;
        // If pattern pointer reaches the end but string pointer doesn't, they don't match
        if(j>=pLength) return false;

        // Check if the current characters match of pattern character is '.'
        boolean match = (i<sLength && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // If next character in pattern is '*'
        if((j+1) < pLength && p.charAt(j+1) == '*') 
            // Either skip '*' & check the rest of the pattern or use '*' to match current character in string
            return (dfs(i, j+2, s, p) || (match && dfs(i+1, j, s, p)));

        // If characters match, move to the next characters in both string and pattern
        if(match) return dfs(i+1, j+1, s, p);

        // If characters don't match & no '*' to help, string don't match
        return false;
    }
}