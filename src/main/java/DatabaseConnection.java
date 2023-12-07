import java.sql.*;

abstract public class DatabaseConnection {
    Connection con;
    String url;

    public void connect(String login, String password) throws SQLException {
        this.con = DriverManager.getConnection(this.url, login, password);
    }

    public void disconnect() throws SQLException {
        this.con.close();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = this.con.createStatement();
        return statement.executeQuery(sql);
    }
}
