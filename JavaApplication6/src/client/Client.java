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
    private Socket clientSocket;
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

    Client()
    {
        view = new LotteryView();
        controller = new LotteryController(view);
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("JavaApplication6/conf.properties")) {
            properties.load(in);
            address = properties.getProperty("address");
            PORT = Integer.parseInt(properties.getProperty("PORT"));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error in configuration files!");
        }
        try {
            clientSocket = new Socket(address, PORT);
            if (clientSocket != null && clientSocket.isConnected()) {
                serverConnection = true;
            }
            output = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    clientSocket.getOutputStream())), true);
            input = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Application can't connect to the server!");
        }

    }

    public void sendRequest(String request) {
        try {
            if (!serverConnection) {
                return;
            }
            output.println(request);
            String response = input.readLine();

        } catch (IOException e) {
            System.out.println("Cant connect to server.");

        }
    }

    public static void main(String [] args){
        Client client = new Client();
        Scanner input = new Scanner(System.in);
        String request = input.next();
        client.sendRequest(request);
    }

}
