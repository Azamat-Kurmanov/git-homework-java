package com.example.server.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    public static final String AUTH_COMMAND = "/auth";
    public static final String AUTH_OK_COMMAND = "/authOk";
    public static final String LIMIT_IS_EXCEEDED = "/outLimit";   //----Практическое задание:7
    public static final String PARTICULAR_USERNAME = "/w";   //----Практическое задание:7
    private MyServer server;
    private final Socket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private int limit = 2;     //----Практическое задание:7 ---Лимит для входа

    public ClientHandler(MyServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream());
        new Thread(() -> {
            try {
                authenticate();
                readMessages();
            } catch (IOException e) {
                System.err.println("Failed to process message from client");
                e.printStackTrace();
            } finally {
                try {
                    closeConnection();
                } catch (IOException e) {
                    System.err.println("Failed to close connection");
                }
            }
        }).start();
    }

    private void authenticate() throws IOException {
        int numberOfAuth = 0;
        while(true) {
            String message = inputStream.readUTF();
            if (numberOfAuth<limit) {
                if (message.startsWith(AUTH_COMMAND)) {
                    String[] parts = message.split(" ");
                    String login = parts[1];
                    String password = parts[2];

                    String userName = this.server.getAuthService().getUserNameByLoginAndPassword(login, password);

                    if (userName == null) {
                        sendMessage("Некорректный логин и пароль");
                    } else {
                        sendMessage(String.format("%s %s", AUTH_OK_COMMAND, userName));
                        server.subscribe(this);
                        server.subscribeInMap(this, userName);
                        return;
                    }
                    numberOfAuth ++;
                }
            } else {
                sendMessage(LIMIT_IS_EXCEEDED);   //----Практическое задание:7
                return;
            }
        }

    }

    private void readMessages() throws IOException {
        while (true){
            String message = inputStream.readUTF().trim();
            if (message.startsWith("/end")){
                return;
            } else if (message.startsWith(PARTICULAR_USERNAME)){   //----Практическое задание:7
                String[] parts = message.split(" ");
                String userName = parts[1];
                String onlyMessage = message.replaceAll(PARTICULAR_USERNAME + " " + userName + " ", "");
                processForPersonalMessage(onlyMessage, userName);
            } else {
                processMessage(message);
            }
        }
    }

    private void processForPersonalMessage(String message, String username) throws IOException{   //----Практическое задание:7
        if (message.length()>0 && !username.isEmpty()){
            this.server.personalMessage(message, username);
        }

    }
    private void processMessage(String message) throws IOException {
        this.server.broadcastMessage(message, this);
    }

    public void sendMessage(String message) throws IOException {
        this.outputStream.writeUTF(message);
    }

    private void closeConnection() throws IOException {
        outputStream.close();
        inputStream.close();
        server.unsubscribe(this);
        clientSocket.close();
    }
}
