package utils;

import java.util.Stack;

public class Node {

    private Node parent;
    private Node leftNode;
    private Node rightNode;

    public Node() {
        this.leftNode = null;
        this.rightNode = null;
    }
    public int countParents(){
        int cnt = 0;
        Node node = getParent();
        while (node != null) {
            cnt++;
            node = node.getParent();
        }
        return cnt;
    }

    public long getMagnitude() throws Exception {
        long leftMag = leftNode.isLeaf() ? ((Leaf) leftNode).getValue() : leftNode.getMagnitude();
        long rightMag = rightNode.isLeaf() ? ((Leaf) rightNode).getValue() : rightNode.getMagnitude();
        return 3 * leftMag + 2 * rightMag;
    }

    public Node addNode(Node other) throws Exception {
        Node n = new Node();
        n.setLeft(this);
        n.setRight(other);
        return n;
    }


    public void setLeft(Node node) throws Exception {
        if (leftNode != null) {
            throw new Exception("Left node already set");
        }
        if (node.parent != null) {
            throw new Exception("The node already has parent");
        }
        node.parent = this;
        leftNode = node;
    }

    public void setRight(Node node) throws Exception {
        if (rightNode != null) {
            throw new Exception("Right node already set");
        }
        if (node.parent != null) {
            throw new Exception("The node already has parent");
        }
        node.parent = this;
        rightNode = node;
    }

    public void replaceLeft(Node node) throws Exception {
        if (node.parent != null) {
            throw new Exception("The node already has parent");
        }
        if (leftNode != null) {
            leftNode.parent = null;
        }
        node.parent = this;
        leftNode = node;
    }

    public void replaceRight(Node node) throws Exception {
        if (node.parent != null) {
            throw new Exception("The node already has parent");
        }
        if (rightNode != null) {
            rightNode.parent = null;
        }
        node.parent = this;
        rightNode = node;
    }

    public Node getLeft() {
        return leftNode;
    }

    public Node getRight() {
        return rightNode;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return false;
    }


    public static class Leaf extends Node {

        int value;

        public Leaf(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public void setLeft(Node node) throws Exception {
            throw new Exception("Child nodes cannot be set at Leaf node");
        }

        @Override
        public void setRight(Node node) throws Exception {
            throw new Exception("Child nodes cannot be set at Leaf node");
        }

        @Override
        public boolean isLeaf() {
            return true;
        }

        @Override
        public long getMagnitude() throws Exception {
            throw new Exception("Leaf node does not have a magnitude");
        }

        public void split() throws Exception {
            if (value >= 10) {
                int left = (int) Math.floor(value / 2.0);
                int right = (int) Math.ceil(value / 2.0);
                Node n = new Node();
                n.setLeft(new Leaf(left));
                n.setRight(new Leaf(right));
                Node parent = getParent();
                if (parent.getLeft() == this) {
                    parent.replaceLeft(n);
                } else {
                    parent.replaceRight(n);
                }
            }
        }
    }

    public static class SnailNumberIterator {
        private Stack<Node> stack;
        private boolean initialized = false;
        private Node root = null;

        public SnailNumberIterator(Node root) {
            this.root = root;
        }

        private void init() {
            stack = new Stack<Node>();
            Node current = root;

            while (current != null) {
                stack.push(current);
                current = current.leftNode;
            }
        }

        public Node current() {
            return stack.peek();
        }

        public boolean next() {
            if (initialized) {
                Node tmp = stack.peek().rightNode;
                stack.pop();
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.leftNode;
                }
            } else {
                init();
                initialized = true;
            }
            return !stack.isEmpty();
        }
    }
}