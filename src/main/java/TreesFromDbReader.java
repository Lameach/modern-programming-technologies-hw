import java.sql.ResultSet;
import java.util.ArrayList;

public class TreesFromDbReader {

    public static ArrayList<Tree> buildTrees(DatabaseConnection con) {
        ArrayList<Tree> trees = new ArrayList<Tree>();
        try {
            ResultSet result = con.executeQuery("select * from public.\"TREES\"");

            while (result.next()) {
                int nodeId = result.getInt(1);
                int parentNodeId = result.getInt(2);

                if (nodeId == parentNodeId) {
                    Tree tree = new Tree(nodeId);
                    trees.add(tree);
                } else {
                    trees.forEach(tree -> {
                        ArrayList<Node> nodes = tree.getAllNodes();
                        for (Node node: nodes) {
                            if (node.getId() == parentNodeId) {
                                node.addChild(new Node(nodeId));
                            }
                        }
                    });
                }
            }

            return trees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trees;
    }
}
