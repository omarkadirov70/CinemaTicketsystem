

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public ClientSocket() {
        try {
            socket= new Socket("localhost", 2002);
            output=new ObjectOutputStream(socket.getOutputStream());
            input=new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addMovie(Movies movies){
        Packet packet= new Packet("ADD_MOVIES", movies);
        try {
            output.writeObject(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Movies> getAllMovies(){
        ArrayList<Movies> movies=new ArrayList<>();
        Packet packet=new Packet("ALL_MOVIES", null);
        try {
            output.writeObject(packet);
            Packet packet1=(Packet) input.readObject();
            movies=(ArrayList<Movies>) packet1.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void deleteMovies(Movies movies){
        Packet packet=new Packet("DELETE_MOVIES", movies);
        try {
        output.writeObject(packet);
        } catch (Exception e) {
        e.printStackTrace();
        }
        }


}
