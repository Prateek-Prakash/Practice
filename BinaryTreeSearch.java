class NodeA {
    int data;
    NodeA left;
    NodeA right;

    public NodeA(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    // DFS
    // IN-ORDER
    // Left, Root, Right
    public void printInOrder(NodeA node) {
        if (node == null) {
            return;
        }
        this.printInOrder(node.left);
        System.out.print(node.data + " ");
        this.printInOrder(node.right);
    }

    // DFS
    // PRE-ORDER
    // Root, Left, Right
    public void printPreOrder(NodeA node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        this.printPreOrder(node.left);
        this.printPreOrder(node.right);
    }

    // DFS
    // POST-ORDER
    // Left, Right, Root
    public void printPostOrder(NodeA node) {
        if (node == null) {
            return;
        }
        this.printPostOrder(node.left);
        this.printPostOrder(node.right);
        System.out.print(node.data + " ");
    }
}

class TreeA {
    NodeA root;

    public TreeA() {
        this.root = null;
    }

    public int getHeight(NodeA node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = getHeight(node.left);
            int rHeight = getHeight(node.right);

            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    // BFS
    // LEVEL-ORDER
    public void printLevelOrder(NodeA node) {
        for (int i = 0; i < getHeight(node); i++) {
            this.printCurrentLevel(node, i);
        }
    }

    private void printCurrentLevel(NodeA node, int level) {
        if (node == null) {
            return;
        } else {
            if (level == 0) {
                System.out.print(node.data + " ");
            } else if (level > 0) {
                this.printCurrentLevel(node.left, level - 1);
                this.printCurrentLevel(node.right, level - 1);
            }
        }
    }
}

class BinaryTreeSearch {
    public static void main(String[] args) {
        TreeA tree = new TreeA();
        tree.root = new NodeA(1);
        tree.root.left = new NodeA(2);
        tree.root.right = new NodeA(3);
        tree.root.left.left = new NodeA(4);
        tree.root.left.right = new NodeA(5);

        System.out.print("InOrder: ");
        tree.root.printInOrder(tree.root);
        System.out.println();

        System.out.print("PreOrder: ");
        tree.root.printPreOrder(tree.root);
        System.out.println();

        System.out.print("PostOrder: ");
        tree.root.printPostOrder(tree.root);
        System.out.println();

        System.out.print("LevelOrder: ");
        tree.printLevelOrder(tree.root);
        System.out.println();
    }
}