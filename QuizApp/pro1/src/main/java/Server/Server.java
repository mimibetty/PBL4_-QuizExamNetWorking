/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.quizapplication.Client;
import com.quizapplication.ConnectionJDBC;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class Server {
    private int port;

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
    public ClientHandler(Socket sk){
        this.socket = sk;
    }
    
    public void postStudent(){
        String[] datas = new String[Client.StudentInfoNum];
        try {
            for (int i = 0; i < Client.StudentInfoNum; i++) {
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
    
    public void getAllStudents(){
        try {
            String[] datas = new String[Client.StudentInfoNum];
            String marks = in.readUTF();
            System.out.println("marks: "+ marks);
            
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("Select * from student where marks >=" + marks + " ");
            
            // Number of Students
            rs.last();
            out.writeUTF(String.valueOf(rs.getRow()));
            rs.beforeFirst();
            
            while (rs.next()) {
                datas[0] = rs.getString("RollNo");
                datas[1] = rs.getString("Name");
                datas[2] = rs.getString("gender");
                datas[3] = rs.getString("address");
                datas[4] = rs.getString("marks");
                
                out.writeUTF(datas[0]);
                out.writeUTF(datas[1]);
                out.writeUTF(datas[2]);
                out.writeUTF(datas[3]);
                out.writeUTF(datas[4]);
            }  
           conn.close();
           st.close();
           rs.close();
        } catch (Exception e) {
        }
    }
     public void getAllQuestions(){
        try {
            String[] datas = new String[Client.QuestionInfoNum];
//            String marks = in.readUTF();
            System.out.println("server ");
            
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("select * from question");
            // Number of Question
            rs.last();
            out.writeUTF(String.valueOf(rs.getRow()));
            rs.beforeFirst();
            
            while (rs.next()) {
                datas[0] = rs.getString("ID");
                datas[1] = rs.getString("Name");
                datas[2] = rs.getString("Opt1");
                datas[3] = rs.getString("Opt2");
                datas[4] = rs.getString("Opt3");
                datas[5] = rs.getString("Opt4");
                datas[6] = rs.getString("Answer");
                
                out.writeUTF(datas[0]);
                out.writeUTF(datas[1]);
                out.writeUTF(datas[2]);
                out.writeUTF(datas[3]);
                out.writeUTF(datas[4]);
                out.writeUTF(datas[5]);
                out.writeUTF(datas[6]);
            
            }  
           conn.close();
           st.close();
           rs.close();
        } catch (Exception e) {
        }
    }
     
//    public void GetAllQuestion() {
//        try {
//            Connection conn = ConnectionJDBC.getConn();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("select * from question");
//
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            while (rs.next()) {
//                String id = rs.getString("ID");
//                String name = rs.getString("Name");
//                String op1 = rs.getString("Opt1");
//                String op2 = rs.getString("Opt2");
//                String op3 = rs.getString("Opt3");
//                String op4 = rs.getString("Opt4");
//                String ans = rs.getString("Answer");
//                oos.writeObject(new Object[] {id, name, op1, op2, op3, op4, ans});
//            }
//            
//            rs.close();
//            statement.close();
//            conn.close();
//            oos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
    
    @Override
    public void run(){
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in= new DataInputStream(socket.getInputStream());

            while(true){
                //Nhận dữ liệu từ client
                String clientRequest = in.readUTF();
                if(clientRequest != null) {
                    System.out.println(clientRequest);
                }
                switch (clientRequest) {
                    case "postStudent":
                        postStudent();
                        break;
                    case "getAllStudents":
                        getAllStudents();
                        break;
                    case "getAllQuestions":
                        getAllQuestions();
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