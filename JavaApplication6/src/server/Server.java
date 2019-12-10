/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import server.model.*;

/**
 * Main file of Lottery application
 *
 * @author Student
 */
public class Server implements Closeable {


    /**
     * port number
     */
    private int PORT;

    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;

    private Lottery model;

    /**
     * Creates the server socket
     *
     *
     */
    Server() {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("JavaApplication6/conf.properties")) {
            properties.load(in);
            PORT = Integer.parseInt(properties.getProperty("PORT"));
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments.First argument should be number of
     *             numbers you want to bet. Second argument is last number program can pick
     *             (from 1 to this number). Next x arguments(x = first argument) should be
     *             numbers you want to bet.
     */
    public static void main(String[] args) {

        Lottery model = new Lottery();
        try (Server server = new Server()) {
            System.out.println("Server started");
            while (true) {
                Socket socket = server.serverSocket.accept();
                try (SingleService singleService = new SingleService(socket)) {
                    singleService.realize(model);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }

}


