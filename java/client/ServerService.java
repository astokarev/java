package client;

import server.Message;

import java.io.IOException;
import java.net.SocketException;

public interface ServerService {

    boolean isConnected();
    void openConnection();
    void closeConnection();
    String authorization(String login, String password) throws IOException;

    void sendMessage(String message);
    Message readMessages();

}