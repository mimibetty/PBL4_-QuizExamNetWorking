/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.quizapplication.Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Server {
    private int port;
    // Name, MSSV, LSH, Mark, NNumber_Error, Detecting_Error
    public static int StudentInfoNum = 6;

    public Server(int port){
        System.out.println("Hello");
        this.port = port;
        this.execute();
    }
    
    public void execute(){
         try{
            ServerSocket serverSocket = new ServerSocket(port);
 
            // Create Socket for each user
            while (true) {
                Socket socket = serverSocket.accept(); 
                ClientHandler clientSock = new ClientHandler(socket);
                new Thread(clientSock).start();
            }
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        Server server = new Server(6666);
    }
    
}

class ClientHandler implements Runnable{
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    String ID_Account;
    int role;
    public ClientHandler(Socket sk){
        this.socket = sk;
    }
    
    public void postStudent(){
        String[] datas = new String[Server.StudentInfoNum];
        try {
            for (int i = 0; i < Server.StudentInfoNum; i++) {
                datas[i] = in.readUTF();
            }
            
            Connection conn = ConnectionJDBC.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?)");
            ps.setString(1, datas[0]);
            ps.setString(2, datas[1]);
            ps.setString(3, datas[2]);
            ps.setString(4, datas[3]);
            ps.setString(5, datas[4]);
            ps.executeUpdate();
            ps.close();
            conn.close();
            out.writeUTF("true");
            
        } catch (Exception e) {
            try {
                out.writeUTF("false");      
            } catch (Exception ex) {
            }
        }
    }
    
    public void getAllStudentsByMark(){
        try {
            System.out.println("Get ALl Student");
            String[] datas = new String[Server.StudentInfoNum];
            String mark = in.readUTF();
            System.out.println("mark: "+ mark);
            
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT AI.Name, AI.MSSV, AI.LSH, R.Mark, R.Number_Error, R.Detecting_Error\n" +
                                            "FROM Account_Info AI\n" +
                                            "JOIN Result R ON AI.ID_Account = R.ID_Account\n" +
                                            "WHERE R.Mark >=" + mark + " ");
            // Number of Students
            ArrayList<String[]> resultSetCopy = new ArrayList<String[]>();

            while (rs.next()) {
                String[] rowData = new String[Server.StudentInfoNum];
                for (int i = 0; i < Server.StudentInfoNum; i++) {
                    rowData[i] = rs.getString(i + 1);
                }
                resultSetCopy.add(rowData);
            }
            out.writeUTF(String.valueOf(resultSetCopy.size()));

            for(int j = 0; j< resultSetCopy.size(); j++){
                for (int i = 0; i < Server.StudentInfoNum; i++) {
                    out.writeUTF(resultSetCopy.get(j)[i]); 
                }
            }
           conn.close();
           st.close();
           rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getQuestionNum() {
        try {
            Connection conn = ConnectionJDBC.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as NumberQuestion FROM question;");
            if (rs.next()) {
                out.writeUTF(rs.getString("NumberQuestion"));
            } else {
                out.writeUTF("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getStudentInfoByID(){
        try {
            String[] datas = new String[Server.StudentInfoNum];
            String idAccount = in.readUTF();
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT AI.Name, AI.MSSV, AI.LSH, R.Mark, R.Number_Error, R.Detecting_Error\n" +
                                            "FROM Account_Info AI\n" +
                                            "JOIN Result R ON AI.ID_Account = R.ID_Account\n" +
                                            "WHERE R.ID_Account =" + idAccount + " ");
            
            if(rs.next()){
                for(int i = 0; i< Server.StudentInfoNum; i++){
                    datas[i] = rs.getString(i+1); 
                    out.writeUTF(datas[i]);
                }
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
        }

    }
    public void sumitRequest(){
        try {
            String mark = in.readUTF();
            Connection conn = ConnectionJDBC.getConn();
            Statement statement = conn.createStatement();
            String updateQuery = "UPDATE result SET mark = '" + mark + "' WHERE ID_Account = '" + ID_Account + "'";
            int rowsAffected = statement.executeUpdate(updateQuery);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public void login(){
        try {
            String username = in.readUTF();
            String password = in.readUTF();
            
            
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT ID_Account, role FROM account WHERE username ='"+username+"' AND password ='"+ password+"'");
            
            if(rs.next()){
                out.writeUTF("Login Succeed");
                ID_Account = rs.getString("ID_Account");
                role = rs.getInt("role");
                
                out.writeUTF(String.valueOf(role));
                out.writeUTF(ID_Account);
                if(role == 1){
                    rs = st.executeQuery("SELECT Name, MSSV, LSH\n" +
                                                    "FROM Account_Info \n" +
                                                    "WHERE ID_Account ='" + ID_Account + "' ");
                    if(rs.next()){
                        for(int i = 0; i< 3; i++){
                            out.writeUTF(rs.getString(i+1));
                        }
                    }
                }
            }
            else{
                out.writeUTF("Login Fail");
                System.out.println("Fail");

            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
        }
    }
    
    public void getQuestionByID(){
        try {
            String[] datas = new String[Server.StudentInfoNum];
            String ID_Queston = in.readUTF();
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT *\n" +
                                            "FROM question\n" +
                                            "WHERE ID_Question ='" + ID_Queston + "' ");
            if(rs.next()){
                // Không lấy cột ID_Question
//                datas[0] = rs.getString(2);
//                datas[1] = rs.getString(3);
//                datas[2] = rs.getString(4);
//                datas[3] = rs.getString(5);
//                datas[4] = rs.getString(6);
//                datas[5] = rs.getString(7);


                for(int i = 0; i< 6; i++){
                    datas[i] = rs.getString(i+2); 
                    out.writeUTF(datas[i]);
                }
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void run(){
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in= new DataInputStream(socket.getInputStream());

            while(true){
                //Nhận dữ liệu từ client
                String clientRequest = in.readUTF();
                switch (clientRequest) {
                    case "postStudent":
                        postStudent();
                        break;
                    case "getAllStudents":
                        getAllStudentsByMark();
                        break;
                    case "getQuestionNumber":
                        getQuestionNum();
                        break;
                    case "getStudentInfoByID":
                        getStudentInfoByID();
                        break;
                    case "login":
                        System.out.println("Login");
                        login();
                        break;
                    case "getQuestionByID":
                        getQuestionByID();
                        break;
                    case "submitRequest":
                        sumitRequest();
                        break;
                    default:
                        throw new AssertionError();
                }

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}