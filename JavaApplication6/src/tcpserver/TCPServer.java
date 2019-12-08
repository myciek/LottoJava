/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;


/**
 * Main file of Lottery application
 *
 * @author Student
 */
public class  TCPServer implements Closeable {


    /**
     * port number
     */
    private int PORT;

    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;

    /**
     * Creates the server socket
     *
     *
     */
    TCPServer() {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("conf.properties")) {
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
     * @param args the command line arguments.Firts argument should be number of
     *             numbers you want to bet. Second argument is last number program can pick
     *             (from 1 to this number). Next x arguments(x = first argument) should be
     *             numbers you want to bet.
     */
    public static void main(String[] args) {

//        Lottery model = new Lottery();
//        LotteryView view = new LotteryView();
//        LotteryController client.controller = new LotteryController(model, view);
//        client.controller.LotteryCheckArguments(args);
//        client.controller.LotteryDrawnNumbers();
//        client.controller.updateView();
        try (TCPServer tcpServer = new TCPServer()) {
            System.out.println("Server started");
            while (true) {
                Socket socket = tcpServer.serverSocket.accept();
                try (SingleService singleService = new SingleService(socket)) {
                    singleService.realize();
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


