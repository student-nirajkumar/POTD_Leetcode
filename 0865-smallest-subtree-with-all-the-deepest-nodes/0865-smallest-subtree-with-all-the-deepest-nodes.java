class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    int maxD = 0;

    TreeNode LCA(TreeNode root) {
        if (root == null || mp.getOrDefault(root.val, -1) == maxD) {
            return root;
        }
        TreeNode l = LCA(root.left);
        TreeNode r = LCA(root.right);

        if (l != null && r != null) {
            return root;
        }
        if (l != null) {
            return l;
        } else {
            return r;
        }

    }

    public void depth(TreeNode root, int d) {
        if (root == null)
            return;

        maxD = Math.max(maxD, d);
        mp.put(root.val, d);

        depth(root.left, d + 1);
        depth(root.right, d + 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root, 0);
        return LCA(root);
    }
}