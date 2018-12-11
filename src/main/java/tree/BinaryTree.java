package tree;

public class BinaryTree {
    private Node root;

    public void addChild(int value) {
        if (root == null) {
            root = new Node(value);
        } else addChild(root, value);
    }

    private void addChild(Node node, int value) {
        if (value < node.value) {
            if (node.leftChild == null) {
                node.leftChild=new Node(value);
                node.leftChild.parent=node;
            } else addChild(node.leftChild, value);
        } else if (node.value < value) {
            if (node.rightChild == null) {
                node.rightChild=new Node(value);
                node.rightChild.parent=node;
            } else addChild(node.rightChild, value);
        }
    }

    public boolean findValue(int value) {
        if(root.getValue()==value) return true;
        else if(root.getValue()<value) return findValue(root.getRightChild(),value);
        else return findValue(root.getLeftChild(),value);
    }


    private boolean findValue(Node node,int value) {
        if(node==null) return false;
        if(node.getValue()==value) return true;
        else if(node.getValue()<value) return findValue(node.getRightChild(),value);
        else return findValue(node.getLeftChild(),value);

    }


    private Node getTheMostLeftChild(Node node){
        while(node.getLeftChild()!=null){
            node=node.getLeftChild();
        }
        return  node;
    }
    private Node getTheMostRightChild(Node node){
        while(node.getRightChild()!=null){
            node=node.getRightChild();
        }
        return  node;
    }


    public void deleteChild(int value) {
        if(root.getValue()==value) {
            Node newRoot;
            Node rightChildOfNewRoot;
            if(root.getRightChild()!= null) {
                newRoot=getTheMostLeftChild(root.getRightChild());
                if(newRoot.getRightChild()!=null) {
                    rightChildOfNewRoot=newRoot.getRightChild();
                    newRoot.getParent().leftChild=rightChildOfNewRoot;
                    rightChildOfNewRoot.parent=newRoot.getParent();
                }
                root.getLeftChild().parent=newRoot;
                root.getRightChild().parent=newRoot;
                newRoot.leftChild=root.getLeftChild();
                newRoot.rightChild=root.getRightChild();
                newRoot.parent=null;
                root=newRoot;
            }
            else if(root.getLeftChild()!=null){
                Node leftChildOfNewRoot;
                newRoot=getTheMostRightChild(root.getLeftChild());
                if(newRoot.getLeftChild()!=null) {
                    leftChildOfNewRoot=newRoot.getRightChild();
                    newRoot.getParent().leftChild=leftChildOfNewRoot;
                    leftChildOfNewRoot.parent=newRoot.getParent();
                }
                root.getLeftChild().parent=newRoot;
                root.getRightChild().parent=newRoot;
                newRoot.leftChild=root.getLeftChild();
                newRoot.rightChild=root.getRightChild();
                newRoot.parent=null;
                root=newRoot;
            }
            else{
                root=null;
            }
        }
        else if(root.getValue()<value)  deleteChild(root.getRightChild(),value);
        else deleteChild(root.getLeftChild(),value);
    }
    private void delete(Node node){
        Node newRoot;
        Node rightChildOfNewRoot;
        if(node.getRightChild()!= null) {
            newRoot=getTheMostLeftChild(node.getRightChild());
            if(newRoot.getRightChild()!=null) {
                rightChildOfNewRoot=newRoot.getRightChild();
                newRoot.getParent().leftChild=rightChildOfNewRoot;
                rightChildOfNewRoot.parent=newRoot.getParent();
            }
            node.getLeftChild().parent=newRoot;
            node.getRightChild().parent=newRoot;
            newRoot.leftChild=node.getLeftChild();
            newRoot.rightChild=node.getRightChild();
            newRoot.parent=null;
            node=newRoot;
        }
        else if(node.getLeftChild()!=null){
            Node leftChildOfNewRoot;
            newRoot=getTheMostRightChild(node.getLeftChild());
            if(newRoot.getLeftChild()!=null) {
                leftChildOfNewRoot=newRoot.getLeftChild();
                newRoot.getParent().rightChild=leftChildOfNewRoot;
                leftChildOfNewRoot.parent=newRoot.getParent();
            }
            node.getLeftChild().parent=newRoot;
            node.getRightChild().parent=newRoot;
            newRoot.leftChild=node.getLeftChild();
            newRoot.rightChild=node.getRightChild();
            newRoot.parent=null;
            node=newRoot;
        }
        else{
            node=null;
        }

    }

    private void deleteChild(Node node,int value) {

        if(node.getValue()==value) {
            delete(node);
        }

        else if(node.getValue()<value)  deleteChild(node.getRightChild(),value);
        else deleteChild(node.getLeftChild(),value);

    }

    public void postOrder() {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.value);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.value);
        }
    }

    public void  inOrder() {
        if (root != null) {
            inOrder(root.leftChild);
            System.out.println(root.value);
            inOrder(root.rightChild);
        }
    }


    private void inOrder(Node node) {
        if (node != null) {
           inOrder(node.leftChild);
            System.out.println(node.value);
            inOrder(node.rightChild);
        }
    }

    public void  preOrder() {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }



    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public static void main(String[] arg) {
        BinaryTree tree = new BinaryTree();
        tree.addChild(50);
        tree.addChild(30);
        tree.addChild(70);
        tree.addChild(20);
        tree.addChild(40);
        tree.addChild(60);
        tree.addChild(80);


        // tree.postOrder();
        // tree.postOrder();
        tree.deleteChild(30);
        tree.preOrder();
        System.out.println(tree.findValue(-8));


    }

}
