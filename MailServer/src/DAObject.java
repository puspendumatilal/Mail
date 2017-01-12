
import java.sql.*;

public class DAObject {

    private Statement dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");																						//Class.forName("sun.jdbc.odbc.JbdcOdbcDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 																						//String url = "jdbc:odbc:dsn";
        Connection conn = DriverManager.getConnection(url, "system", "oracle");
        Statement st = conn.createStatement();
        return st;
    }

    protected void insertMailRegistration(String str) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();

        if (str == null) {
            MailServer mailServer = new MailServer();
            str = mailServer.getStr();
        } else {
            String[] sArray = new String[20];
            int i = 0;
            for (String retval : str.split("\n")) {
                sArray[i] = retval;
                i++;
            }
            String sqlRegistration = "INSERT INTO MailRegistration VALUES ('" + sArray[1] + "','" + sArray[2] + "','" + sArray[3] + "','" + sArray[4] + "','" + sArray[5] + "','" + sArray[6] + "','" + sArray[7] + "','" + sArray[8] + "','" + sArray[9] + "','" + sArray[10] + "')";
            st.executeQuery(sqlRegistration);
            AllVariable av = new AllVariable();
            av.setUserName(sArray[3]);
            insertRegister(sArray[3]);
            createTable(sArray[3]);
            System.out.println("insertMailRegistration");
        }
    }

    protected void insertUserImage(String uname, String imgpath) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String sqlRegistration = "INSERT INTO UserImage VALUES ('" + uname + "','" + imgpath + "')";
        st.executeQuery(sqlRegistration);
        System.out.print("insertUserImage");
    }

    protected void createTable(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        if (uname == null) {
            AllVariable av = new AllVariable();
            uname = av.getUserName();
        } else {
            String inbox = uname + "Inbox";
            String outbox = uname + "Outbox";
            String draft = uname + "Draft";
            //from is keyword in database
            String inboxCreate = "create table " + inbox + " (from_ varchar(30),subject varchar(20),text varchar(200),docpath varchar(50))";
            st.executeQuery(inboxCreate);
            String outboxCreate = "create table " + outbox + " (to_ varchar(30),subject varchar(20),text varchar(200),docpath varchar(50))";
            st.executeQuery(outboxCreate);
            String draftCreate = "create table " + draft + " (to_ varchar(30),subject varchar(20),text varchar(200),docpath varchar(50))";
            st.executeQuery(draftCreate);

            System.out.println("createTable");
        }
    }

    protected String onClickLogin(String str) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String result = null;
        
        if (str == null) {
            MailServer mailServer = new MailServer();
            str = mailServer.getStr();
        } else {
            String[] sArray = new String[20];
            int i = 0;
            for (String retval : str.split("\n")) {
                sArray[i] = retval;
                i++;
            }

            String query1 = "select uname,pasword from MailRegistration where uname = '" + sArray[1] + "' ";
            System.out.println(query1);
            ResultSet rs = st.executeQuery(query1);
            if (rs.next()) {
                String name = (String) rs.getString("uname");

                String pas = (String) rs.getString("pasword");
                result = name + "\n" + pas + "\n";
            }
            System.out.println("onClickLogin");
        }
        //System.out.println(result);
        return result;
    }

    protected void deleteTable(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        if (uname == null) {
            AllVariable av = new AllVariable();
            uname = av.getUserName();
        }

        String in = uname + "Inbox";
        String out = uname + "Outbox";
        String drft = uname + "Draft";
        String inboxDrop = "drop table " + in;
        String outboxDrop = "drop table " + out;
        String draftDrop = "drop table " + drft;
        st.executeQuery(inboxDrop);
        st.executeQuery(outboxDrop);
        st.executeQuery(draftDrop);
        System.out.print("deleteTable");
    }

    protected void deleteUser(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String userdelete = "delete from MailRegistration where uname=" + uname;
        String userImagedelete = "delete from UserImage where uname=" + uname;
        String userRegisterdelete = "delete from Register where uname=" + uname;
        st.executeQuery(userRegisterdelete);   //Register should delete first
        st.executeQuery(userImagedelete);
        st.executeQuery(userdelete);
        System.out.print("deleteUser");
    }

    protected void insertRegister(String uname) throws ClassNotFoundException, SQLException {
        //working fine
        Statement st = dbConnection();
        if (uname == null) {
            AllVariable av = new AllVariable();
            uname = av.getUserName();
        } else {
            String inbox = uname + "Inbox";
            String outbox = uname + "Outbox";
            String draft = uname + "Draft";
            String insertRegister = "INSERT INTO Register VALUES ('" + uname + "','" + inbox + "','" + outbox + "','" + draft + "')";
            st.executeQuery(insertRegister);
            System.out.println("insertRegister");
        }
    }

    protected ResultSet onClickInbox(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String query1 = "select inboxName from Register where uname=" + uname;
        ResultSet rs = st.executeQuery(query1);
        String query2 = "select * from " + rs.getString("inboxName");
        st.executeQuery(query2);
        return st.executeQuery(query2);
        //may have problem      
    }

    protected ResultSet onClickOutbox(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String query1 = "select outboxName from Register where uname=" + uname;
        ResultSet rs = st.executeQuery(query1);
        String query2 = "select * from " + rs.getString("outboxName");
        st.executeQuery(query2);
        return st.executeQuery(query2);
        //may have problem      
    }

    protected ResultSet onClickDraft(String uname) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        String query1 = "select draftName from Register where uname=" + uname;
        ResultSet rs = st.executeQuery(query1);
        String query2 = "select * from " + rs.getString("draftName");
        st.executeQuery(query2);
        return st.executeQuery(query2);
        //may have problem      
    }

    protected void onClickSendButton(String uname, String to, String subject, String text, String docpath) throws ClassNotFoundException, SQLException {
        Statement st = dbConnection();
        //here uname will be treated as from field in <username>Inbox
        String str = "insert into " + to + "Inbox VALUES ('" + uname + "','" + subject + "','" + text + "','" + docpath + "')";
        st.executeQuery(str);
    }
}