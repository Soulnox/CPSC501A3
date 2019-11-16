import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public static void main(String args[]) throws IOException {
        String fileName = "Receiver.xml";
        FileOutputStream fos = new FileOutputStream(fileName);
        ServerSocket socket = null;
        Socket clientSocket = null;
        int count;

        SAXBuilder sb = new SAXBuilder();
        Deserializer deserial = new Deserializer();

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

        byte[] buffer = new byte[1024];
        while((count = in.read(buffer)) > 0) {
            fos.write(buffer, 0, count);
        }
        in.close();
        clientSocket.close();
        socket.close();

        try {
            Visualizer.visualize(deserial.deserialize(sb.build(fileName)));;
        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }
}
