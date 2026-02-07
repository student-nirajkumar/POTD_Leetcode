import java.util.Stack;

class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int count = 0;

        while (i < s.length()) {
            if (!st.isEmpty() && st.peek() == 'b' && s.charAt(i) == 'a') {
                st.pop();     
                count++;
            } else {
                st.push(s.charAt(i));
            }
            i++;
        }
        return count;
    }
}
