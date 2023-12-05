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

    public Server(int port) {
        System.out.println("Hello");
        this.port = port;
        this.execute();
    }

    public void execute() {
        try {
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

class ClientHandler implements Runnable {

    Socket socket;
    DataOutputStream out;
    DataInputStream in;

    public ClientHandler(Socket sk) {
        this.socket = sk;
    }

    public void postStudent() {
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

    public void getAllStudents() {
        try {
            String[] datas = new String[Client.StudentInfoNum];
            String marks = in.readUTF();
            System.out.println("marks: " + marks);

            Connection conn = new ConnectionJDBC().getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from student where marks >=" + marks + " ");

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

    public void getAllQuestions() {
        try {
            String[] datas = new String[Client.QuestionInfoNum];
//            String marks = in.readUTF();
            System.out.println("server ");

            Connection conn = new ConnectionJDBC().getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from question");
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

    public void getNumberQuestions() {
        try {

            Connection conn = new ConnectionJDBC().getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from question");
            // Number of Question
            rs.last();
            out.writeUTF(String.valueOf(rs.getRow()));

            System.out.println("this server" + String.valueOf(rs.getRow()));
            rs.beforeFirst();

            conn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void AddQuestion() {
        String[] datas = new String[Client.QuestionInfoNum];
        try {
            for (int i = 0; i < Client.QuestionInfoNum; i++) {
                datas[i] = in.readUTF();
//                System.out.println(datas[i]);
            }

            Connection conn = ConnectionJDBC.getConn();

            PreparedStatement ps = conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
            ps.setString(1, datas[0]);
            ps.setString(2, datas[1]);
            ps.setString(3, datas[2]);
            ps.setString(4, datas[3]);
            ps.setString(5, datas[4]);
            ps.setString(6, datas[5]);
            ps.setString(7, datas[6]);

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

    public void UpdateQuestion() {

        String[] datas = new String[Client.QuestionInfoNum];
        try {
            for (int i = 0; i < Client.QuestionInfoNum; i++) {
                datas[i] = in.readUTF();
//                System.out.println(datas[i]);
            }

            Connection conn = ConnectionJDBC.getConn();
            PreparedStatement ps = conn.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=?");
            ps.setString(7, datas[0]);
            ps.setString(1, datas[1]);
            ps.setString(2, datas[2]);
            ps.setString(3, datas[3]);
            ps.setString(4, datas[4]);
            ps.setString(5, datas[5]);
            ps.setString(6, datas[6]);
            System.err.println("wwhy :  " + ps);

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

    public void DeleteQuestion() {

        try {
            String id = in.readUTF();
            Connection connection = ConnectionJDBC.getConn();
            PreparedStatement ps = connection.prepareStatement("delete from question where id=?");
            ps.setString(1, id);

            ps.executeUpdate();
            ps.close();
            connection.close();
            out.writeUTF("true");
        } catch (Exception e) {
            System.err.println(e);
            System.out.println(e);
            try {
                out.writeUTF("false");
            } catch (Exception ex) {
            }
        }
    }

    public void IsIDExist() {
        try {
            Connection conn = new ConnectionJDBC().getConn();
            Statement st = conn.createStatement();
            String id = in.readUTF();

            ResultSet rs = st.executeQuery("select * from question where id = " + id);
            if (rs.first()) {
                out.writeUTF("true");
            } else {
                out.writeUTF("false");
            }
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void SearchQuestionAtID() {
        try {
            String[] datas = new String[Client.QuestionInfoNum];
            String id = in.readUTF();

            Connection conn = new ConnectionJDBC().getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from question where id = " + id);
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

    public void ResetIDDelete() {
        try {
            Connection conn = ConnectionJDBC.getConn();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select Id from question; ");
            int id = 1;
            while (rs.next()) {
                int old = rs.getInt("ID");
                if (old != id) {
                    UpdateID(old, id);
                }
                id++;
            }
            statement.close();
            conn.close();
            rs.close();
        } catch (Exception e) {

        }
    }

    private void UpdateID(int old, int news) {
        try {
            Connection conn = ConnectionJDBC.getConn();
            PreparedStatement statement = conn.prepareStatement("UPDATE question SET ID=? where ID=?;");
            statement.setInt(1, news);
            statement.setInt(2, old);
            int rowsAffected = statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            while (true) {
                //Nhận dữ liệu từ client
                String clientRequest = in.readUTF();
                if (clientRequest != null) {
                    System.out.println("request from server" + clientRequest);
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
                    case "getNumberQuestion":
                        getNumberQuestions();
                        break;
                    case "AddQuestion":
                        AddQuestion();
                        break;
                    case "UpdateQuestion":
                        UpdateQuestion();
                        break;
                    case "DeleteQuestion":
                        DeleteQuestion();
                        break;
                    case "IsIDExist":
                        IsIDExist();
                        break;
                    case "SearchQuestionAtID":
                        SearchQuestionAtID();
                        break;
                    case "ResetIDDelete":
                        ResetIDDelete();
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
