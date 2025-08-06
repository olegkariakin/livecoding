package trees;

import java.util.LinkedList;
import java.util.List;

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
        System.out.println(STR."Traversing: \{root.value}");
        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

        reverseRecursively(root.leftChild);
        reverseRecursively(root.rightChild);
    }

    public static void reverseSequentially(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }

            TreeNode temp = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = temp;
        }
    }
}
