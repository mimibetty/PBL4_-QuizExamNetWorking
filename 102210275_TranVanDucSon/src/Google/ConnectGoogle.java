package Google;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.FileWriter;
import java.io.IOException;
public class ConnectGoogle {
    public static void main(String[] args) {
        String host = "www.google.com";
        int port = 80;
        try (Socket socket = new Socket(host, port);
             PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             FileWriter fileWriter = new FileWriter("index.html")) {
            socketOut.println("GET / HTTP/1.1");
            socketOut.println("Host: " + host);
            socketOut.println("Connection: close");
            socketOut.println();
            String inputLine;
            boolean headerEnded = false; 
            while ((inputLine = socketIn.readLine()) != null) {
                if (headerEnded) {
                    fileWriter.write(inputLine + "\n");
                } else if (inputLine.isEmpty()) {
                    headerEnded = true;
                }
            }
            fileWriter.flush();
            View();
           } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void View() throws IOException {
    	File htmlFile = new File("index.html");
    	Desktop.getDesktop().browse(htmlFile.toURI());
    } 
}
