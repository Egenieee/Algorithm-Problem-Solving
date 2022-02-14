package leetcode.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> inorderTraversal = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);

        root.right = treeNode1;
        treeNode1.left = treeNode2;

        solution.inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversal = new ArrayList<>();
        inorder(root);
        for(int num : inorderTraversal) {
            System.out.println(num);
        }
        return inorderTraversal;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        inorderTraversal.add(root.val);
        inorder(root.right);
    }
}
