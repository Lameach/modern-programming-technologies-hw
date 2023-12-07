import java.util.ArrayList;

public class Tree {
    Node root;

    public Tree (int rootId) {
        this.root = new Node(rootId);
    }

    public Node getRoot() {
        return root;
    }

    public ArrayList<Node> getAllNodes() {
        ArrayList<Node> nodesList = new ArrayList<Node>();
        nodesList.add(this.root);
        this.visitNode(this.root, nodesList);
        return nodesList;
    }

    private void visitNode(Node currentNode, ArrayList<Node> nodesList) {
        nodesList.addAll(currentNode.getChildren());

        for (Node node: currentNode.getChildren()) {
            visitNode(node, nodesList);
        }
    }

    public ArrayList<Node> getAllLeaves() {
        ArrayList<Node> allNodes = this.getAllNodes();
        ArrayList<Node> allLeaves = new ArrayList<Node>(allNodes.stream().filter(Node::isLeaf).toList());
        return allLeaves;
    }
}
