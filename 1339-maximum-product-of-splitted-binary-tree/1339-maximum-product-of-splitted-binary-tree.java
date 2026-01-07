class Solution {

    long SUM = 0; 
    long maxP = 0;
    public int totalSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSubtreeSum = totalSum(root.left);
        int rightSubtreeSum = totalSum(root.right);

        int sum = root.val + leftSubtreeSum + rightSubtreeSum;
        return sum;
    }
    long find(TreeNode root) {
        if (root == null)
            return 0;
        long left = find(root.left);
        long right = find(root.right);
        long currSum = root.val + left + right;
        long product = currSum * (SUM - currSum);
        maxP = Math.max(maxP, product);

        return currSum;
    }
    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        SUM = totalSum(root);
        find(root);
        return (int)(maxP % 1000000007);
    }
}
