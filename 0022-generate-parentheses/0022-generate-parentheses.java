class Solution {

    public boolean isValid(String str){

        int sum = 0;

        for(int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);

            if(ch == '('){
                sum++;
            }
            else{
                sum--;
            }

            if(sum < 0){
                return false;
            }
        }

        return sum == 0;
    }

    public void generate(String curr, int n, int length, List<String> res){

        if(length == 2 * n){

            if(isValid(curr)){
                res.add(curr);
            }

            return;
        }

        curr += '(';

        generate(curr, n, length + 1, res);

        curr = curr.substring(0, curr.length() - 1);

        curr += ')';

        generate(curr, n, length + 1, res);

        curr = curr.substring(0, curr.length() - 1);
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generate("", n, 0, res);

        return res;
    }
}