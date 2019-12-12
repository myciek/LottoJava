package client;
import java.io.*;
import client.controller.*;
import client.view.LotteryView;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {

    /**
     * Represents socket, that connects with server.
     */
    private Socket socket;
    /**
     * Formated output stream.
     */
    private PrintWriter output;

    /**
     * Buffered input stream.
     */
    private BufferedReader input;

    /**
     * Port number, at which server is placed.
     */
    private int PORT;

    /**
     * IP address, at which server is placed.
     */
    private String address;

    /**
     * Used to report errors that occurred during communication with server.
     */
    private LotteryController controller;

    private  LotteryView view;

    /**
     * Contains information about connection with server. True if it was
     * succesful.
     */
    private boolean serverConnection;

    Client() {
        try {
            Properties properties = new Properties();
            try (FileInputStream in = new FileInputStream("JavaApplication6/conf.properties")) {
                properties.load(in);
                address = properties.getProperty("address");
                PORT = Integer.parseInt(properties.getProperty("PORT"));
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in configuration files!");
            }
            socket = new Socket(address, PORT);
            output = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    this.socket.getOutputStream())), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }



//    public void write(String request) {
//        try {
//            output.writeBytes(request +'\n');
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        }
//
//    public String read(){
//
//        String result="";
//        try {
//            result = input.readLine();
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//        return result;
//    }
    public void close(){

        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String [] args){

        Client client = new Client();
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.next();
        client.output.println(str);
    }

}
