import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender {

    private static DataOutputStream outBuffer;

    public static void main(String args[]) throws IOException {


        if (args.length != 2) {
            System.out.println("ERROR: Incorrect number of arguments.  Proper usage: java Sender [receiver ip] [receiver port]");
        }

        Socket senderSocket = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Connected to Receiver" + args[0] + "@" + args[1]);
        outBuffer = new DataOutputStream(senderSocket.getOutputStream());



        senderSocket.close();
    }
}
