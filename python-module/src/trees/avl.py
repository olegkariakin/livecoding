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
        T2 = y.left

        # rotate
        y.left = z
        z.right = T2

        # Update heights
        z.height = 1 + max(self.get_height(z.left),
                           self.get_height(z.right))
        y.height = 1 + max(self.get_height(y.left),
                           self.get_height(y.right))

        return y
