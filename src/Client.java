import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String inputString;

        do {
            inputString = scanner.nextLine();
            dataOutputStream.writeUTF(inputString);
            dataOutputStream.flush();

            String serverMessage = dataInputStream.readUTF();
            System.out.println("Сообщение от сервера: " + serverMessage);


        } while (!"\\finish".equals(inputString));
        socket.close();
    }

}