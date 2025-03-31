public class Solution {
    public boolean check(String word, String target) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (target.charAt(i) != '*' && word.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int minimumTimeToInitialState(String s, int k) {
        int n = s.length();
        int c = 0;
        String copy = s;

        do {
            copy = copy.substring(k) + "*".repeat(k);
            c++;
        } while (!check(s, copy));

        return c;
    }
}
