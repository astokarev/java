import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SecondClient {
    public static void main(String[] args) throws IOException {
        String id = "Johny Silverhand";
        Socket socket = new Socket("localhost",8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String inputString;
        do {
            inputString = scanner.nextLine();
            dataOutputStream.writeUTF(inputString);
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String serverMessage = dataInputStream.readUTF();
            System.out.println("Сообщение от сервера: " + serverMessage);
        } while (!"\\finish".equals(inputString));
        socket.close();
    }
}