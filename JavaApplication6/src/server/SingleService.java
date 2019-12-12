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
    private BufferedReader in;
    /**
     * Formatted output character stream
     */
    private PrintWriter out;


    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client
     */
    private String response;

    private String request;

    private String [] args;

    public SingleService(Socket socket) throws IOException {
        try {
            this.socket=socket;

            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream())),true);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Realizes the service
     */
    public void realize(Lottery model) {
        try {
            out.println("Service start");
            boolean connect = true;
            while(connect) {
                String str = in.readLine();
                System.out.println("Clinet sent: " + str);
                switch (str.toUpperCase())
                {
                    case "HELP":
                        out.println(help);
                        break;

                    case "QUIT":
                        out.println("QUIT");
                        connect = false;
                        break;

                    default:
                        out.println("Arguments accepted");
                        String args[] = str.split(",");
                        try{
                            model.checkArguments(args);
                            out.println("Gitara");

                        }
                        catch (WrongArgumentsException e)
                        {
                            out.println(e.getMessage());
                        }
                }

        }
        }catch (IOException e)
            {
                System.err.println(e.getMessage());
            }
        finally {
            try {
                close();
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
