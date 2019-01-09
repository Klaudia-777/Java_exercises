package tree;

public class Node {
    public Node parent;
    public Node leftChild;
    public Node rightChild;
    public int value;


    public Node() {
    }

    public Node(int value) {
        this.value = value;
        rightChild = null;
        leftChild = null;
    }

    public Node(Node node) {
        this(node.getValue());
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}