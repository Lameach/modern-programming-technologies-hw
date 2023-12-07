import java.util.ArrayList;

public class Node {
    int id;
    ArrayList<Node> children;
    Node parent;

    public Node (int id) {
        this.id = id;
        this.children = new ArrayList<Node>();
    }

    public int getId() {
        return id;
    }

    public Node getParent() {
        return parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }
    
    public Boolean isRoot() {
        return this.parent == null;
    }

    public Boolean isLeaf() {
        return this.children.isEmpty();
    }
}
