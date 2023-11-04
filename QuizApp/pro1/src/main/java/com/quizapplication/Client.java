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
    
    public Client(int port){
        this.port = port;
        this.execute();
    }
    public void execute(){
        try {
            socket = new Socket("localhost", this.port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean postStudent(String[] datas){
        String result ="";
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
        if(result.equals("true")){
            return true;
        }
        return false;
    }

    public ArrayList<String[]> getAllStudents(int mark){
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
