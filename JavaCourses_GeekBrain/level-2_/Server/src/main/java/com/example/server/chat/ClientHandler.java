package com.example.server.chat;

import com.example.commands.Command;
import com.example.commands.CommandType;
import com.example.commands.commands.AuthCommandData;
import com.example.commands.commands.PrivateMessageCommandData;
import com.example.commands.commands.PublicMessageCommandData;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {

    private MyServer server;
    private final Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private String userName;

    public ClientHandler(MyServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        inputStream = new ObjectInputStream(clientSocket.getInputStream());
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
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
        while(true) {
            Command command = readCommand();

            if (command == null){
                continue;
            }

            if (command.getType() == CommandType.AUTH) {
                AuthCommandData data = (AuthCommandData) command.getData();

                String login = data.getLogin();
                String password = data.getPassword();

                String userName = this.server.getAuthService().getUserNameByLoginAndPassword(login, password);

                if (userName == null) {
                    sendCommand(Command.errorCommand("Некорректные имя пользователя или пароль"));
                    checkUserName(false, this, null);      //--Практическое задание №8
                } else if(server.isUserNameBusy(userName)){
                    sendCommand(Command.errorCommand("Такой пользователь уже существует"));
                    checkUserName(false, this, null);      //--Практическое задание №8
                } else {
                    this.userName = userName;
                    sendCommand(Command.authOkCommand(userName));
                    server.subscribe(this);
                    checkUserName(true, this, userName);      //--Практическое задание №8
                    return;
                }
            }
        }

    }

    private void checkUserName(boolean result, ClientHandler clientHandler, String userName) {      //--Практическое задание №8
        Timer timer = new Timer(true);
        if(!result){
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        server.unsubscribe(clientHandler);
                        System.out.println("Неавторизованный пользователь был отключен в: " + new Date());
                    } catch (IOException e) {
                        System.out.println("Соединение с пользователем было разорвано");
                        e.printStackTrace();
                    }
                }
            };
            System.out.println("Не авторизован");
            timer.schedule(timerTask, 120_000);
            System.out.println("Запустился процесс отключения неавторизованных пользователей по таймауту");
        } else {
            timer.cancel();
            System.out.println("Пользователь " + userName + " был авторизован и процесс отключения был отменен");
        }

    }

    private Command readCommand() throws IOException {
        Command command = null;
        try {
            command = (Command) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to read Command class");
            e.printStackTrace();
        }

        return command;
    }

    private void readMessages() throws IOException {
        while (true){
            Command command = readCommand();
            if (command == null){
                continue;
            }
            switch (command.getType()){
                case PRIVATE_MESSAGE: {
                    PrivateMessageCommandData data = (PrivateMessageCommandData) command.getData();
                    String receiver = data.getReceiver();
                    String privateMessage = data.getMessage();
                    server.sendPrivateMessage(this, receiver, privateMessage);
                    break;
                }
                case PUBLIC_MESSAGE:
                    PublicMessageCommandData data = (PublicMessageCommandData) command.getData();
                    processMessage(data.getMessage());
                    break;
            }
        }
    }

    private void processMessage(String message) throws IOException {
        this.server.broadcastMessage(message, this);
    }

    public void sendCommand(Command command) throws IOException {
        outputStream.writeObject(command);
    }

    private void closeConnection() throws IOException {
        outputStream.close();
        inputStream.close();
        server.unsubscribe(this);
        clientSocket.close();
    }

    public String getUserName() {
        return userName;
    }
}
