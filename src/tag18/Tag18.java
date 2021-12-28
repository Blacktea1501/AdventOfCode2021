package tag18;

import utils.Node;

import java.io.File;
import java.util.*;

public class Tag18 {


    public static void main(String[] args) throws Exception {
        List<String> fishNumbers = new ArrayList<>();
        Scanner sc = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag18/input.txt"));
        Node node = null;
        if (sc.hasNextLine()) {
            node = createSnailFishNumber(sc.nextLine());

        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Node n = createSnailFishNumber(line);
            node = node.addNode(n);
            reduce(node);
        }

        if (node == null) {
            System.out.println("File is empty!");
            return;
        }

        System.out.println("Magnitude: " + node.getMagnitude());

        sc.close();
        sc = new Scanner(new File("/home/artur/IdeaProjects/AdventOfCode/src/tag18/input.txt"));
        while(sc.hasNextLine()){
            fishNumbers.add(sc.nextLine());
        }
        System.out.println("Biggest Magnitude: " + getLargestMagnitude(fishNumbers));
    }

    private static long getLargestMagnitude(List<String> fishNumbers) throws Exception {

        long mag = -1;
        for (int i = 0; i < fishNumbers.size() - 1; i++) {
            for (int j = i + 1; j < fishNumbers.size(); j++) {
                Node first = createSnailFishNumber(fishNumbers.get(i));
                Node second = createSnailFishNumber(fishNumbers.get(j));
                Node finalNode = first.addNode(second);
                reduce(finalNode);

                long m = finalNode.getMagnitude();
                if (m > mag) {
                    mag = m;
                }
            }
        }

        return mag;
    }

    private static void reduce(Node node) throws Exception {
        boolean somethingToSplit = true;

        while (somethingToSplit) {
            List<Node> nodesToExplode = getNodesToExplode(node);
            explodeAll(nodesToExplode);
            somethingToSplit = false;
            Node.SnailNumberIterator iterator = new Node.SnailNumberIterator(node);
            while (iterator.next()) {
                Node current = iterator.current();
                if (current.isLeaf()) {
                    Node.Leaf leaf = (Node.Leaf) current;
                    if (leaf.getValue() >= 10) {
                        leaf.split();
                        somethingToSplit = true;
                        break;
                    }
                }
            }
        }
    }

    private static List<Node> getNodesToExplode(Node root) {
        List<Node> nodesToExplode = new ArrayList<>();
        Node.SnailNumberIterator iterator = new Node.SnailNumberIterator(root);
        while (iterator.next()) {
            Node current = iterator.current();
            if (mustBeExploded(current)) {
                nodesToExplode.add(current);
            }
        }
        return nodesToExplode;
    }

    private static boolean mustBeExploded(Node node) {
        if (node.isLeaf()) {
            return false;
        }
        if (!(node.getLeft().isLeaf() && node.getRight().isLeaf())) {
            return false;
        }
        return node.countParents() == 4;
    }


    private static void explodeAll(List<Node> nodes) throws Exception {
        for (Node n : nodes) {
            explode(n);
        }
    }

    private static void explode(Node pair) throws Exception {
        int leftValue = ((Node.Leaf) (pair.getLeft())).getValue();
        int rightValue = ((Node.Leaf) (pair.getRight())).getValue();
        Node.Leaf leftLeaf = firstLeftRegularNumber(pair);
        if (leftLeaf != null) {
            leftLeaf.setValue(leftValue + leftLeaf.getValue());
        }
        Node.Leaf rightLeaf = firstRightRegularNumber(pair);
        if (rightLeaf != null) {
            rightLeaf.setValue(rightValue + rightLeaf.getValue());
        }
        Node pairParent = pair.getParent();
        if (pairParent.getLeft() == pair) {
            pairParent.replaceLeft(new Node.Leaf(0));
        } else {
            pairParent.replaceRight(new Node.Leaf(0));
        }

    }

    private static Node.Leaf firstLeftRegularNumber(Node pair) {
        Node parent = pair.getParent();
        while (parent != null && parent.getLeft().equals(pair)) {
            pair = parent;
            parent = parent.getParent();
        }
        if (parent == null) {
            return null;
        }
        Node node = parent.getLeft();

        while (!node.isLeaf()) {
            node = node.getRight();
        }
        return (Node.Leaf) node;
    }

    private static Node.Leaf firstRightRegularNumber(Node pair) {
        Node parent = pair.getParent();
        while (parent != null && parent.getRight().equals(pair)) {
            pair = parent;
            parent = parent.getParent();
        }
        if (parent == null) {
            return null;
        }
        Node node = parent.getRight();

        while (!node.isLeaf()) {
            node = node.getLeft();
        }
        return (Node.Leaf) node;
    }

    private static Node createSnailFishNumber(String input) throws Exception {
        input = input.substring(1); // assume the character at index 0 is an opening square bracket ([)
        Stack<Node> stack = new Stack<Node>();
        Node rootNode = new Node();
        Node current = rootNode;

        for (char c : input.toCharArray()) {
            if (c == '[') {
                Node n = new Node();
                if (current.getLeft() == null) {
                    current.setLeft(n);
                } else {
                    current.setRight(n);
                }
                stack.push(current);
                current = n;
            } else if (c == ']') {
                if (current != rootNode) {
                    current = stack.pop();
                }
            } else if (c == ',') {
                // do nothing
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new Node.Leaf(Integer.parseInt(String.valueOf(c))));
                } else {
                    current.setRight(new Node.Leaf(Integer.parseInt(String.valueOf(c))));
                }
            }
        }
        return rootNode;
    }

}
