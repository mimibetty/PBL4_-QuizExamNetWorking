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
                        getAllStudents();
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