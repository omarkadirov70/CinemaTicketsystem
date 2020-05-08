import java.sql.*;

public class Connect3 {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/sales_product?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";
    //   -_-
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch(Exception e){
            System.out.println("Connection failed...");
            e.printStackTrace();
            return null;
        }
    }