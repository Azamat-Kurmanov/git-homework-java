package ru.geekbrains.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientApp {
    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 8191;

    public static void main(String[] args) throws IOException {
        serverConnection();
    }

    private static void serverConnection() throws IOException {
        Socket socket = null;
        Thread thread = null;
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Порт клиента запущен");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            thread = receiveServerMessage(inputStream);
            sendMessageToServer(outputStream);

        } catch (IOException e) {
            System.err.println("Соединение с сервером разорвано");
            e.printStackTrace();
        } finally {
            if (thread != null) {
                thread.interrupt();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }

    private static Thread receiveServerMessage(DataInputStream inputStream){
        Thread serverThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    String message = inputStream.readUTF();
                    System.out.println("Сообщение получено от сервера: " + message);
                    if (message.startsWith("/end")){
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.err.println("Подключение разорвано");
                    System.exit(0);
                    break;
                }
            }
        });
        serverThread.start();
        return serverThread;
    }

    private static void sendMessageToServer(DataOutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = DateFormat.getTimeInstance().format(new Date())+" "+scanner.nextLine();
            outputStream.writeUTF(message);
            if (message.startsWith("/end")){
                break;
            }
        }
    }

}
