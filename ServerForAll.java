import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerForAll {
    public static Connection connection;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticket?useUnicode=true&serverTimezone=UTC", "root", "");
            ServerSocket serverSocket=new ServerSocket(2002);
            System.out.println("Waiting for user synchronization");
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("Client connected");
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addMovies(Movies movies){
        try {
            PreparedStatement statement=connection.prepareStatement("" + "INSERT INTO movies(id,name,duration,rating,price,count) " + " VALUES(null, ?, ?, ?, ?, ?) ");
            statement.setString(1, movies.getName());
            statement.setString(2, movies.getDuration());
            statement.setString(3, movies.getRating());
            statement.setInt(4,movies.getPrice());
            statement.setInt(5, movies.getCount());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Movies> getAllMovies(){
        ArrayList<Movies> movies=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("" + "SELECT * FROM movies");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                String duration=resultSet.getString("duration");
                String rating=resultSet.getString("rating");
                int price=resultSet.getInt("price");
                int count=resultSet.getInt("count");
                movies.add(new Movies(id,name,duration,rating,price,count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public static void deleteMovies(Long id){
        try {
        PreparedStatement statement=connection.prepareStatement(" DELETE FROM movies WHERE id=? ");
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
        }

}
