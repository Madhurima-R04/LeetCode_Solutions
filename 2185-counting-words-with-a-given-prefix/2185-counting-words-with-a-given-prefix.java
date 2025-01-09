class Solution {
    public int prefixCount(String[] words, String pref) {
        int n=pref.length();
        int c=0;
        for(String w:words)
        {
            if(w.length()>=n && w.startsWith(pref))
                c++;
        }
        return c;
    }
}