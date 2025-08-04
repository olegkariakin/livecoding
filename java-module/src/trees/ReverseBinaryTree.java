package trees;

public class ReverseBinaryTree {

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(9);

        TreeNode nodeLeft = new TreeNode(2, leaf1, leaf2);
        TreeNode nodeRight = new TreeNode(7, leaf3, leaf4);

        TreeNode root = new TreeNode(4, nodeLeft, nodeRight);
        reverseRecursively(root);
        System.out.println("Reversing Binary Tree");
    }

    public static void reverseRecursively(TreeNode root) {
        if (root.leftChild == null || root.rightChild == null) {
            return;
        }
        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        reverseRecursively(root.leftChild);
        reverseRecursively(root.rightChild);
    }
}
