import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int bmax[] = new int[26];

        // Calculate the maximum frequency of each letter across all words in words2
        for (String b : words2) {
            int bCount[] = new int[26];
            for (char ch : b.toCharArray()) {
                bCount[ch - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                bmax[i] = Math.max(bmax[i], bCount[i]);
            }
        }

        // Check each word in words1 to see if it satisfies the bmax conditions
        List<String> ans = new ArrayList<>();
        for (String a : words1) {
            int aCount[] = new int[26];
            for (char ch : a.toCharArray()) {
                aCount[ch - 'a']++;
            }
            if (isSubset(bmax, aCount)) {
                ans.add(a);
            }
        }
        return ans;
    }

    // Helper function to check if aCount covers bmax
    private static boolean isSubset(int bmax[], int aCount[]) {
        for (int i = 0; i < 26; i++) {
            if (aCount[i] < bmax[i]) {
                return false;
            }
        }
        return true;
    }
}
