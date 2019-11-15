import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public static void main(String args[]) throws IOException {

        ServerSocket socket = null;
        Socket clientSocket = null;

        if (args.length != 1) {
            System.out.println("Incorrect number of arguments.  USAGE: java Receiver [Receiver Port Number]");
            return;
        }

        try {
            socket = new ServerSocket(Integer.parseInt(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        clientSocket = socket.accept();
        System.out.println("Accept connection from " + clientSocket.toString());
        InputStream in = clientSocket.getInputStream();

        in.close();
        clientSocket.close();
        socket.close();
    }
}
