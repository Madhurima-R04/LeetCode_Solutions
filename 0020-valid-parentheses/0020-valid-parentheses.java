class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c); // Push opening brackets onto the stack
            } else {
                if (st.isEmpty()) {
                    return false; // No opening bracket to match
                }
                char top = st.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false; 
                }
            }
        }
        return st.isEmpty(); // Ensure all brackets are matched
    }
}
