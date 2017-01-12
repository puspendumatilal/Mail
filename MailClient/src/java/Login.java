
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    private ServletResponse res;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userName=req.getParameter("username");
       String passwd=req.getParameter("pasword");
       String s="login\n"+userName+"\n"+passwd+"\n";
       ClientSocket cs=new ClientSocket();
       String loginResponce=cs.clientSocketLogin(s);
       String[] respnse=new String[5];
       int i=0;
       for(String retval:loginResponce.split("\n")){
           respnse[i]=retval;
           i++;
       }
       
       if((userName.equals(respnse[0])) && (passwd.equals(respnse[1]))){
       resp.sendRedirect("Profile.jsp");
       }
       else{
           PrintWriter pr=resp.getWriter();
           pr.print("username or pasword not correct");
       }
       
    }
    }

