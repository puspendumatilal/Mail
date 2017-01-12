
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientSocket {

    //modify it
    private String server = "127.0.0.1";
    private int servPort = 44944;
    private byte[] byteBuffer;

    protected void clientSocketOutput(String str) throws UnknownHostException, IOException {

        //	throw new IllegalArgumentException("enter parameter: <Server> <echoWord> [<port>]");


        int i = 0;
        Socket socket = new Socket(server, servPort);
        byteBuffer = str.getBytes();
        System.out.println("Connected to server...sending echo string");
        OutputStream out = socket.getOutputStream();

        out.write(byteBuffer);  // Send the encoded string to the server

        socket.close();
        System.out.println("Connection closed");

    }

    protected String clientSocketLogin(String s) throws SocketException, UnknownHostException, IOException {
        Socket socket = new Socket(server, servPort);
        int totalBytesRcvd = 0;
        byteBuffer = s.getBytes();
        OutputStream out = socket.getOutputStream();
        out.write(byteBuffer);
        InputStream in = socket.getInputStream();
        int bytesRcvd;
        while (totalBytesRcvd < byteBuffer.length) {
            if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd, byteBuffer.length - totalBytesRcvd)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }

            totalBytesRcvd += bytesRcvd;
        }

        System.out.println("Received: " + new String(byteBuffer));
        socket.close(); // Close the socket and its streams
        return new String(byteBuffer);
    }
}
