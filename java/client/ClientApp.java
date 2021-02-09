package client;

import java.io.EOFException;

public class ClientApp {
    public static void main(String[] args) throws EOFException {
        new MyClient().setVisible(true);
    }

}
