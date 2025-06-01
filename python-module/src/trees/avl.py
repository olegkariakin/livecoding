from trees.Node import Node

class AVLTree:
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