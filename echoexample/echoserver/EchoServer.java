package echoexample.echoserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {

    private int port;
    private ObjectInputStream streamFromClient;
    private ObjectOutputStream streamToClient;
    private ServerSocket serverSocket;

    public EchoServer(int inputport) {
        this.port = port;
        streamFromClient = null;
        streamToClient = null;
    }

    private void setup() throws IOException {
        this.serverSocket = new ServerSocket(this.port);
    }

    private void awaitClient() {
        
    }

    public void start() {
        System.out.println("Starting server ...");

        try {
            // create a Server Socket listening to port 50000
            ServerSocket serverSocket = new ServerSocket(50000);

            // Call accept() method to wait for connections
            Socket socket = this.serverSocket.accept();
            // after connection to client is made, the following code will run
            System.out.println("Client connected.");

            // Read and write to socket IP streams
            // read socket input stream that client sent
            this.streamFromClient = new ObjectInputStream(socket.getInputStream());
            // output stream data to client
            this.streamToClient = new ObjectOutputStream(socket.getOutputStream());

            // read data from input stream
            String readString = (String) this.streamFromClient.readObject();
            System.out.println("Recieved from client: " + readString);

            // do something about the data
            String result = readString.toUpperCase();

            // output results to client
            streamToClient.writeObject(result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
