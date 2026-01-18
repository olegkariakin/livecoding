package trees;

// Найти самую большую глубину бинарного дерева используя рекурсивный поиск в глубину
public class DFS {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.leftChild);
            int rightDepth = maxDepth(node.rightChild);

            return Math.max(leftDepth, rightDepth);
        }
    }
}
