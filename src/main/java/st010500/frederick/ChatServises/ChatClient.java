package st010500.frederick.ChatServises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by bf on 10.02.18.
 */
public class ChatClient extends Chat implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient(Socket socket)
    {
        this.socket = socket;
        System.out.println("Client created!!!");
    }

    @Override
    public void run() {
        try {

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!socket.isClosed()){
                String input = in.readLine();
                if(input != null) {
                    for (ChatClient client : chatClients)
                    {
                        client.getWriter().write(input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrintWriter getWriter()
    {
        return out;
    }
}
