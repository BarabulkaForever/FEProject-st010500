package st010500.frederick.ChatServises;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bf on 10.02.18.
 */
public class Chat
{
    private static int PORT_NUMBER = 4444;
    private static ServerSocket SOCKET = null;
    protected static List<ChatClient> chatClients = new ArrayList<>();

    public static void startChat()
    {
        try
        {
            SOCKET = new ServerSocket(PORT_NUMBER);
            acceptClients();
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port " + PORT_NUMBER);
        }
    }


    public static void acceptClients()
    {
        while (true) {
            try {
                Socket clientSocket  = SOCKET.accept();
                ChatClient client = new ChatClient(clientSocket);
                Thread thread = new Thread(client);
                thread.start();
                chatClients.add(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
