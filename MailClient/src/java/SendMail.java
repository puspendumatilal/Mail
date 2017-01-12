

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendMail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String to_=req.getParameter("to_");
       String sub=req.getParameter("subject");
       String text=req.getParameter("textArea");
       // "\n" acts as seperator in MailServer Class to ditermine which function to call
       String toBeSent=new String("inbox\n"+to_+"\n"+sub+"\n"+text+"\n");
       ClientSocket clientSocket = new ClientSocket();

        PrintWriter pr = resp.getWriter();
        pr.print(toBeSent);
        clientSocket.clientSocketOutput(toBeSent);
    }
    
    

}
