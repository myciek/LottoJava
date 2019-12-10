package server;
import server.model.Lottery;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SingleService implements Closeable {

    private static final String help = "HELP: First argument should be number of\n" +
            "     * numbers you want to bet. Second argument is last number program can pick\n" +
            "     * (from 1 to this number). Next x arguments(x = first argument) should be\n" +
            "     * numbers you want to bet.";
    /**
     * socket representing connection to the client
     */
    private Socket socket;
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    /**
     * Formatted output character stream
     */
    private PrintWriter output;

    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client
     */
    public SingleService(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
    }

    /**
     * Realizes the service
     */
    public void realize(Lottery model) {
        try {
            output.println("Service start");
            String data;
            String[] answer;
            while (true) {
                data = input.readLine();
                if(data != null){
                answer = data.split(",");
                try {
                    model.checkArguments(answer);
                    model.drawNumbers();
                    model.numbersHit();

                }catch (WrongArgumentsException e)
                {
                    System.out.println(e.getMessage());
                }

                if (data.toUpperCase().equals("QUIT")) {
                    break;
                }
                System.out.println("Client sent: " + data);
                output.flush();

            }
            }
            System.out.println("closing...");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
