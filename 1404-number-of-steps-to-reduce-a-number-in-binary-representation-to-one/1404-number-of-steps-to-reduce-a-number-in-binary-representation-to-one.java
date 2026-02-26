class Solution {
    public void addOne(StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {

        StringBuilder sb = new StringBuilder(s);
        int op = 0;

        while (sb.length() > 1) {

            int n = sb.length();

            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
            } else {
                addOne(sb);
            }

            op++;
        }

        return op;
    }
}