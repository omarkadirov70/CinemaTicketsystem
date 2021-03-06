

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while(true){
                Packet packet=(Packet)objectInputStream.readObject();
                if(packet.getCode().equals("ADD_MOVIES")){
                    Movies movies=(Movies) packet.getData();
                    ServerForAll.addMovies(movies);
                }
                else if(packet.getCode().equals("ALL_MOVIES")){
                    ArrayList<Movies> movies=ServerForAll.getAllMovies();
                    Packet packet1=new Packet("ALL_MOVIES", movies);
                    objectOutputStream.writeObject(packet1);
                }

                else if(packet.getCode().equals("DELETE_MOVIES")){
                    Movies movies=(Movies) packet.getData();
                    ServerForAll.deleteMovies(movies.getId());
                    }
                    

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
