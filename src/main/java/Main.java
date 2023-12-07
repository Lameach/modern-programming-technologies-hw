import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        H2Connection h2 = new H2Connection("jdbc:h2:~/treeDB");
        try {
            Properties props = PropertiesReader.getProperties(System.getProperty("user.dir") + "\\src\\main\\resources\\properties.properties");
            h2.connect(props.getProperty("h2.login"), props.getProperty("h2.password"));
            ArrayList<Tree> trees = TreesFromDbReader.buildTrees(h2);
            writeToCsv(calculateSumLeavesAmount(trees));
            h2.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int calculateSumLeavesAmount(ArrayList<Tree> trees) {
        int sum = 0;
        for (Tree tree: trees) {
            sum += tree.getAllLeaves().size();
        }
        return sum;
    }

    public static void writeToCsv(int sumLeavesAmount) {
        File csvOutputFile = new File(System.getProperty("user.dir") + "output.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(Integer.toString(sumLeavesAmount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
