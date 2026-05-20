class Solution {

    public void generate(String curr, int n, int length,
                         int open, int close, List<String> res) {

        if (length == 2 * n) {

            res.add(curr);
            return;
        }

        if (open < n) {

            curr += '(';

            generate(curr, n, length + 1, open + 1, close, res);

            curr = curr.substring(0, curr.length() - 1);
        }

        if (close < open) {

            curr += ')';

            generate(curr, n, length + 1, open, close + 1, res);

            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        int open = 0;
        int close = 0;

        generate("", n, 0, open, close, res);

        return res;
    }
}