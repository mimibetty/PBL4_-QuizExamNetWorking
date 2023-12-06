package server;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJDBC {

    public static String DB_URL = "jdbc:mysql://localhost:3306/quiz?useSSL=false";
//    public static String url="jdbc:mysql://127.0.0.1:3306/quiz";
    public static String USER_NAME = "root";
    public static String PASSWORD = "142857SONlun@@";


    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connnect to database 'quiz'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connection to DB successfull");
            return conn;
        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
        
    }

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
    
//    public static void main(String[] args) {
//        String result = "";
//
//            try{
//                Connection conn=ConnectionJDBC.getConn();
//                Statement statement=conn.createStatement();
//                ResultSet rs= statement.executeQuery("select * from student" );
//                while (rs.next()) {
//                    result += rs.getString("rollNo");
//                    result += "\t";
//                    result += rs.getString("Name");
//                    result += "\t";
//                    result +=rs.getString("address");
//                    result += "\t";
//                    result += rs.getString("marks");
//                    result += "\t";
//                    result += rs.getString("gender");
//                    result += "\t";
//                    result += "\n";
//
//                }
//                System.out.println(result);
//                rs.close();
//                statement.close();
//                conn.close();
//            }catch(Exception e){
//            }
//    }
    
    
}
