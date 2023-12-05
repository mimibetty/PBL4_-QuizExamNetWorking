/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quizapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Client {

    private int port;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    public static int StudentInfoNum = 5;
    public static int QuestionInfoNum = 7;

    public Client(int port) {
        this.port = port;
        this.execute();
    }

    public void execute() {
        try {
            socket = new Socket("localhost", this.port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean postStudent(String[] datas) {
        String result = "";
        String request = "postStudent";
        try {
            //Send request to server: Post Student
            out.writeUTF(request);
            //Send data to server: rollNo, name, gender, address, marks
            for (int i = 0; i < StudentInfoNum; i++) {
                out.writeUTF(datas[i]);
            }
            out.flush();
            // Client Nhan ket qua tu Server: true, false
            result = in.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //If server receive packet return true
        if (result.equals("true")) {
            return true;
        }
        return false;
    }

    public ArrayList<String[]> getAllStudents(int mark) {
        ArrayList<String[]> result = new ArrayList<>(1000);
        String request = "getAllStudents";
        try {
            out.writeUTF(request);
            out.writeUTF(String.valueOf(mark));
            //Get the number of students;
            int studentNum = Integer.parseInt(in.readUTF());

            for (int i = 0; i < studentNum; i++) {
                String[] data = new String[Client.StudentInfoNum];
                //read info of each student
                for (int j = 0; j < StudentInfoNum; j++) {
                    data[j] = in.readUTF();
                }

                result.add(data);
            }
        } catch (Exception e) {
        }

        return result;
    }

    public ArrayList<String[]> getAllQuestion() {
        ArrayList<String[]> result = new ArrayList<>(1000);
        String request = "getAllQuestions";
        try {
            out.writeUTF(request);
//            out.writeUTF(String.valueOf(mark));
//            Get the number of question;
            int QuestionNum = Integer.parseInt(in.readUTF());

            for (int i = 0; i < QuestionNum; i++) {
                String[] data = new String[Client.QuestionInfoNum];
                //read info of each student
                for (int j = 0; j < Client.QuestionInfoNum; j++) {
                    data[j] = in.readUTF();
                }

                result.add(data);
            }
        } catch (Exception e) {
        }

        return result;
    }

    public int getNumberQuestion() throws IOException {
        String request = "getNumberQuestion";

//        System.out.println("haha");
        out.writeUTF(request);
//        System.out.println("haha");
        int QuestionNum = Integer.parseInt(in.readUTF());
        System.out.println("client:  " + QuestionNum);

        return QuestionNum;
    }

    public boolean AddQuestion(String[] datas) {
        String result = "";
        String request = "AddQuestion";
        System.out.println("Client pree  ");
        try {
            //Send request to server: Post Student
            out.writeUTF(request);
            //Send data to server: rollNo, name, gender, address, marks
            for (int i = 0; i < QuestionInfoNum; i++) {
                out.writeUTF(datas[i]);
            }
            out.flush();
            // Client Nhan ket qua tu Server: true, false
            System.out.println("Client pree  result");

            result = in.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //If server receive packet return true
        if (result.equals("true")) {
            return true;
        }
        return false;
    }

    public boolean UpdateQuestion(String[] datas) {
        System.out.println("Client Update heree hic hic ");
        String result = "";
        String request = "UpdateQuestion";
        System.out.println(request);

        try {
            //Send request to server: Post Student
            out.writeUTF(request);
            //Send data to server: rollNo, name, gender, address, marks
            for (int i = 0; i < QuestionInfoNum; i++) {
                out.writeUTF(datas[i]);
                System.out.println(datas[i]);
            }
            out.flush();
            // Client Nhan ket qua tu Server: true, false
//                 System.out.println("Client pree  result");

            result = in.readUTF();
            System.out.println("Result:  ++  " + result);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //If server receive packet return true
        if (result.equals("true")) {
            return true;
        }
        return false;
    }

    public boolean DeleteQuestion(String id) {
        System.out.println("Client delete heree hic hic ");
        String result = "";
        String request = "DeleteQuestion";
        System.out.println(request);

        try {
            //Send request to server: Post Student
            out.writeUTF(request);
            //Send data to server: rollNo, name, gender, address, marks
            out.writeUTF(id);
            out.flush();
            // Client Nhan ket qua tu Server: true, false
//                 System.out.println("Client pree  result");

            result = in.readUTF();
            System.out.println("Result:  ++  " + result);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //If server receive packet return true
        if (result.equals("true")) {
            return true;
        }
        return false;
    }
    
    public boolean IsIDExist(String id) {
        if (id.isEmpty()) {
            return false;
        }
        String request = "IsIDExist";
        String result = null;
        try {
            out.writeUTF(request);
            out.writeUTF(id);
       
            out.flush();

            result = in.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //If server receive packet return true
        if (result.equals("true")) {
            return true;
        }
        return false;
    }
//        public List<String> SearchQuestionAtID(String id) {
    public List<String> SearchQuestionAtID(String id) {
        List<String> result = new ArrayList<>();
        String request = "SearchQuestionAtID";
        try {
            out.writeUTF(request);
            out.writeUTF(id);
            
            System.out.println("this is search Client");
            System.out.println(request + id);
            for (int j = 0; j < Client.QuestionInfoNum; j++) {
                    result.add(in.readUTF());
            }
        } 
        catch (Exception e) {
        }

        return result;
    }
    public void ResetIDDelete() {
        String request = "ResetIDDelete";
        try {
            out.writeUTF(request);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        Client client = new Client(6666);
//        client.getAllStudents();
//        
//        ArrayList<String[]> result = client.getAllStudents();
//
//// Iterate over the result list and print each String[] element
//        for (String[] data : result) {
//            System.out.println(Arrays.toString(data));
//        }
//    }
}
