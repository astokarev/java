import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadServer {

    public static void main(String[] args) {
        List<Socket> allClients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Создали серверный сокет");
            do {
                System.out.println("Ожидаем подключение клиента");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                allClients.add(socket);
                new ClientSocketHandler(socket).start();
            } while (allClients.stream().noneMatch(Socket::isConnected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}