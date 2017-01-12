
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //creating variables
        String fn = req.getParameter("fname");
        String ln = req.getParameter("lname");
        String un = req.getParameter("uname");
        String pas = req.getParameter("pasword");
        String mob = req.getParameter("mobile");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String gendr = req.getParameter("gender");
        String contry = req.getParameter("country");

        String strings = new String("registration\n"+fn + "\n" + ln + "\n" + un + "\n" + pas + "\n" + mob + "\n" + day + "\n" + month + "\n" + year + "\n" + gendr + "\n" + contry + "\n");
        ClientSocket clientSocket = new ClientSocket();

        PrintWriter pr = resp.getWriter();
        pr.print(strings);
        clientSocket.clientSocketOutput(strings);    //10 represent no of fields  +1 is for index
        //send the data to server    

    }
}
