import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Sender {

    private static DataOutputStream outBuffer;
    private static Scanner userInput = new Scanner(System.in);
    private static XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
    private static String fileName  = "Sender.xml";
    private static Serializer serial = new Serializer();


    public static void main(String args[]) throws IOException {
        int count;
        File file;
        FileInputStream fis;



        if (args.length != 2) {
            System.out.println("ERROR: Incorrect number of arguments.  Proper usage: java Sender [receiver ip] [receiver port]");
        }

        Socket senderSocket = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Connected to Receiver" + args[0] + "@" + args[1]);
        outBuffer = new DataOutputStream(senderSocket.getOutputStream());

        int selection = 0;
        while (selection > -1) {
            System.out.println("Select an object to create:" +
                    "\n0. Primitive Object" +
                    "\n1. Reference Object" +
                    "\n2. Primitive Array Object" +
                    "\n3. Reference Array Object" +
                    "\n4. Java Collection Object");
            selection = userInput.nextInt();

            if (selection == 0) {
                createPrimitiveClass();
                selection = -1;
            }
            if (selection == 1) {

            }
            if (selection == 2) {

            }
            if (selection == 3) {

            }
            if (selection == 4) {

            }
        }
        file = new File(fileName);
        byte[] buffer = new byte[1024];
        fis = new FileInputStream(file);
        while((count = fis.read(buffer)) > 0) {
            outBuffer.write(buffer, 0, count);
        }
        fis.close();
        outBuffer.flush();
        outBuffer.close();

        //System.out.println("File Created");

        senderSocket.close();
    }

    public static void createPrimitiveClass() throws IOException {
        System.out.println("Creating a primitive Object");
        System.out.println("Enter an integer");
        int integer = userInput.nextInt();
        System.out.println("Enter a float");
        float number = userInput.nextFloat();
        System.out.println("Enter a boolean");
        boolean bool = userInput.nextBoolean();
        PrimitiveClass prim = new PrimitiveClass(integer, number, bool);
        System.out.println("Created PrimitiveClass Object");
        Visualizer.visualize(prim);
        xmlOut.output(serial.serialize(prim), new FileOutputStream(fileName));
    }
}
