
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class MailServer {

    private static int BUFSIZE = 100;
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        int servPort = 44944;
        byte[] byteBuffer = new byte[BUFSIZE];
        ServerSocket servSock = new ServerSocket(servPort);

        for (;;) {
            Socket clntSock = servSock.accept();

            System.out.println("Handling client at " + clntSock.getInetAddress().getHostAddress()
                    + " on port " + clntSock.getPort());
            InputStream in = clntSock.getInputStream();
            OutputStream out=clntSock.getOutputStream();
            in.read(byteBuffer);
            String s = new String(byteBuffer);

            String[] str = new String[20];
            int i = 0;
            for (String retval : s.split("\n")) {
                str[i] = retval;
                i++;
            }
            System.out.println(str[0]);

            if (str[0].equals("registration")) {
                MailServer ms = new MailServer();
                ms.setStr(s);
                DAObject dao = new DAObject();
                dao.insertMailRegistration(s);

                clntSock.close();
            }

            if (str[0].equals("login")) {
                System.out.println("login IF statement");
                MailServer ms = new MailServer();
                ms.setStr(s);
                DAObject dao = new DAObject();
                String result=dao.onClickLogin(s);
              //  System.out.println("****" + result);
                byteBuffer=result.getBytes();
                int j=0;
                
                while(j<byteBuffer.length){
                    out.write(byteBuffer,0,byteBuffer.length);
                    j++;
                }
                clntSock.close();
            }

            if (str.equals("inbox")) {
                //TODO inbox operations
            }
            
            

        }//end for loop

    }
}
//
