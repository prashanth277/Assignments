import java.sql.*;
import java.util.*;

public class Queries<cnt> {
    public static Connection connection = null;
    public static Statement stm = null;
    static Scanner sc = new Scanner(System.in);

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Pramati@123");
            stm = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("connection is established..");
        }
        return connection;

    }

    public static void insertRow() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Book values(?,?,?)");
        System.out.println("enter book_id");
        int x = sc.nextInt();
        System.out.println("enter book_name");
        String name = sc.next();
        System.out.println("enter book_author");
        String author = sc.next();
        preparedStatement.setInt(1, x);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, author);
        preparedStatement.execute();
        display();
    }

    public static void display() throws SQLException {
        ResultSet resultSet = stm.executeQuery("select * from Book ");
        while (resultSet.next()) {
            System.out.print(" b_ :" + resultSet.getInt(1));
            System.out.print(" book_name : " + resultSet.getString(2));
            System.out.print(" book_author : " + resultSet.getString(3));
            System.out.println("");
        }
    }

    public static void deleteRow() throws SQLException {
        String name = sc.next();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from Book where b_name = '" + name + "'");
        preparedStatement.execute();
        display();
        System.out.println("row deleted");
    }

    public static void search() throws SQLException {
        String name = sc.next();
        String sql = "select * from Book where b_name='" + name + "'";
        int cnt = 0;
        ResultSet resultSet = stm.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getInt(1) + " book name:" + resultSet.getString(2) + " author:" + resultSet.getString(3));
            cnt = 1;
        }

        if (cnt == 0) {
            System.out.println("Not Found");
        }
    }
}


