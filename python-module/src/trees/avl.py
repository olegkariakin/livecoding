from trees.Node import Node


class AVLTree:
    def __init__(self):
        pass

    def insert(self, root, key):
        # Insert with basic BST
        if not root:
            return Node(key)
        elif key < root.key:
            root.left = self.insert(root.left, key)
        else:
            root.right = self.insert(root.right, key)

        # Updating the height
        root.height = 1 + max(self.get_height(root.left),
                              self.get_height(root.right))

        # Check balance and balancing the AVL tree
        balance = self.get_balance(root)

        # LL case
        if balance > 1 and key < root.left.key:
            return self.right_rotate(root)

        # RR case
        if balance < -1 and key > root.right.key:
            return self.left_rotate(root)

        # LR case
        if balance > 1 and key > root.left.key:
            root.left = self.left_rotate(root.left)
            return self.right_rotate(root)

        # RL case
        if balance < -1 and key < root.right.key:
            root.right = self.right_rotate(root.right)
            return self.left_rotate(root)

        return root

    def left_rotate(self, z):
        y = z.right
        t2 = y.left

        # rotate
        y.left = z
        z.right = t2

        # Update heights
        z.height = 1 + max(self.get_height(z.left),
                           self.get_height(z.right))
        y.height = 1 + max(self.get_height(y.left),
                           self.get_height(y.right))

        return y

    def right_rotate(self, z):
        y = z.left
        t3 = y.right

        # rotate
        y.right = z
        z.left = t3

        # Update heights
        z.height = 1 + max(self.get_height(z.left),
                           self.get_height(z.right))
        y.height = 1 + max(self.get_height(y.left),
                           self.get_height(y.right))

        return y

    def get_height(self, node):
        if not node:
            return 0
        return node.height

    def get_balance(self, node):
        if not node:
            return 0
        return self.get_height(node.left) - self.get_height(node.right)

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(f"{root.key} (h={root.height})", end=' ')
            self.inorder(root.right)


avl = AVLTree()
root = None
for key in [10, 20, 30, 40, 50, 25]:
    root = avl.insert(root, key)

print("Inorder traversal of AVL tree:")
avl.inorder(root)
print()
