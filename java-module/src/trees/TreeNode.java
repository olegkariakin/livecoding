package trees;

public class TreeNode {

    public int value;
    public TreeNode rightChild;
    public TreeNode leftChild;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
