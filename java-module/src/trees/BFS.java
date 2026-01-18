package trees;

import java.util.LinkedList;
import java.util.Queue;

// Найти максимальную глубину бинарного дерева используя поиск в ширину
public class BFS {
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.leftChild != null) {
                    queue.add(current.leftChild);
                }
                if (current.rightChild != null) {
                    queue.add(current.rightChild);
                }
            }
        }

        return depth;
    }
}
