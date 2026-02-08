class Solution {
    public static int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
         return Math.max(leftHeight , rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (Math.abs(leftH - rightH) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}