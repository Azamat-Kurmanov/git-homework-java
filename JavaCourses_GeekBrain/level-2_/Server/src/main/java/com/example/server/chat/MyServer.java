package com.example.server.chat;

import com.example.server.chat.auth.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyServer {

    private AuthService authService;
    private final List<ClientHandler> clients = new ArrayList<>();
    private final Map<String, ClientHandler> clientsMap = new HashMap<>();    //----Практическое задание:7

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server has started");
            authService = new AuthService();
            while (true) {
                waitAndProcessClientConnection(serverSocket);
            }

        } catch (IOException e){
            System.err.println("Failed to bind port " + port);
        }
    }

    private void waitAndProcessClientConnection(ServerSocket serverSocket) throws IOException {
        while(true){
            System.out.println("Waiting for a new client connection");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client has connected");
            ClientHandler clientHandler = new ClientHandler(this, clientSocket);
            clientHandler.handle();
        }
    }
    
    public void personalMessage(String message, String userName) throws IOException {   //----Практическое задание:7
            if (!userName.isEmpty() && !message.isEmpty()){
                ClientHandler textMessage = clientsMap.get(userName);
                textMessage.sendMessage(message);
            }
    }

    public void broadcastMessage(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            if (client != sender){
                client.sendMessage(message);
            }
        }
    }

    public void subscribeInMap(ClientHandler clientHandler, String userName){
        clientsMap.put(userName, clientHandler);
    }
    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
