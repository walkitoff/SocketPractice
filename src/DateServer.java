import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * prog sends client the current date
 */
public class DateServer {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("[SERVER] is waiting for client connection...");
        Socket client = listener.accept(); //accepts a connection from client using ServerSocket
        System.out.println("[SERVER] Connected to Client!");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println( (new Date()).toString());

        System.out.println("[SERVER] Sent Date.  Closing client...");
        client.close();
        listener.close();

    }
}
