class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            if (!st.isEmpty() || ch != '0') {
                st.push(ch);
            }
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
