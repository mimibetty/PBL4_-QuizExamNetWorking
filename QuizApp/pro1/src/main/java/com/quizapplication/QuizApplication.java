package com.quizapplication;
public class QuizApplication {
    public static Client client;
    private int port = 6666;
    public static void main(String[] args) {
        new Main().setVisible(false);

        new LoginAdmin().setVisible(true);
        client = new Client(6666);

    }
}
