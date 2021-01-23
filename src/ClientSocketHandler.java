
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketHandler extends Thread{
    private Socket socket;

    public ClientSocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            String inputString;
            do {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                inputString = dataInputStream.readUTF();
                System.out.println("Echo client "+socket.getInetAddress()+": "+inputString);
            } while (!"\\finish".equals(inputString));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}