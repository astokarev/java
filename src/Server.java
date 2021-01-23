
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Создали серверный сокет");
            System.out.println("Ожидаем подключение клиента");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            Scanner scanner = new Scanner(System.in);
            String inputString;
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String clientMessage;
            do {
                clientMessage = dataInputStream.readUTF();
                System.out.println("message from user: " + clientMessage);

                inputString = scanner.nextLine();
                dataOutputStream.writeUTF(inputString);
                dataOutputStream.flush();
            } while (!"\\finish".equals(inputString));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}