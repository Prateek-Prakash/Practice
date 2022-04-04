class NodeB {
    int data;
    NodeB left;
    NodeB right;

    public NodeB(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    // TOP VIEW: Complete
    public void printTopView() {
        this.printLeftEdge(true);
        this.printRightEdge(false);
    }

    // TOP VIEW: Left Edge
    private void printLeftEdge(boolean printRoot) {
        if (this.left != null) {
            this.left.printLeftEdge(true);
        }
        if (printRoot) {
            System.out.print(this.data + " ");
        }
    }

    // TOP VIEW: Right Edge
    private void printRightEdge(boolean printRoot) {
        if (printRoot) {
            System.out.print(this.data + " ");
        }
        if (this.right != null) {
            this.right.printRightEdge(true);
        }
    }
}

public class BinaryTreeView {
    public static void main(String[] args) {
        NodeB root = new NodeB(1);
        root.left = new NodeB(2);
        root.right = new NodeB(3);
        root.left.left = new NodeB(4);
        root.left.right = new NodeB(5);
        root.left.right.left = new NodeB(6);

        System.out.print("TopView: ");
        root.printTopView();
        System.out.println();
    }
}
