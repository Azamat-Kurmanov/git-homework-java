package ru.geekbrains.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        Thread thread = null;
        try {
            serverSocket = new ServerSocket(ClientApp.SERVER_PORT);
            System.out.println("Сервер начал работу, ожидаем новые подключения");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            thread = receiveClientMessage(inputStream);
            sendMessageToClient(outputStream);
        } catch (IOException e){
            System.err.println("Ошибка при подключении к порту сервера" + ClientApp.SERVER_PORT);
            e.printStackTrace();
        } finally{
            if(thread != null){
                thread.interrupt();
            }
            if (clientSocket != null){
                clientSocket.close();
            }
            if (serverSocket != null){
                serverSocket.close();
            }
        }
    }

    private static Thread receiveClientMessage(DataInputStream inputStream){
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    String message = inputStream.readUTF();
                    System.out.println("Сообщение получено от клиента: " + message);
                    if (message.startsWith("/end")) {
                        System.exit(0);
                    }
                }catch(IOException e){
                    System.out.println("Сетевое соединение было закрыто");
                    System.exit(0);
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }

    private static void sendMessageToClient(DataOutputStream outputStream){
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = DateFormat.getTimeInstance().format(new Date())+" "+scanner.nextLine();
                if (message.startsWith("/end")){
                    break;
                }
                outputStream.writeUTF("Сообщение отправлено от сервера: " + message);
            }
        }catch(IOException e){
            System.err.println("Ошибка передачи данных по сети");
        }
    }
}
