package client;

import server.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;



public class MyClient extends JFrame {

    private ServerService serverService = new SocketServerService();

    public MyClient() throws EOFException {
        super("Чат");
        setResizable(false);
        serverService.openConnection();

        JPanel jPanel = new JPanel();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!serverService.isConnected()){
                    serverService.closeConnection();
                } else timer.cancel();
            }
        };
        timer.schedule(timerTask, 12000);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 400, 640, 480);

        JTextArea mainChat = new JTextArea();
        mainChat.setLineWrap(true);
        mainChat.setDisabledTextColor(Color.RED);
        mainChat.setEditable(false);
        mainChat.setPreferredSize(new Dimension(500, 800));

        JScrollPane scrollPane = new JScrollPane(mainChat);
        scrollPane.setPreferredSize(new Dimension(10, 500));
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);

        initLoginPanel(mainChat);

        JTextField myMessage = new JTextField();
        myMessage.setPreferredSize(new Dimension(400, 100));

        JButton send = new JButton("Send");
        send.addActionListener(actionEvent -> sendMessage(myMessage));
        myMessage.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(myMessage);
                }
            }
        });

        if (serverService.isConnected()) {
            new Thread(() -> {
                while (true) {
                    printToUI(mainChat, serverService.readMessages());
                }
            }).start();
        }

        add(jPanel);
        add(scrollPane);
        //add(mainChat);
        add(myMessage);
        add(send);

    }

    private void initLoginPanel(JTextArea mainChat) throws EOFException {

        JTextField login = new JTextField();
        login.setMaximumSize(new Dimension(200, 20));
        login.setToolTipText("Логин");

        JPasswordField password = new JPasswordField();
        password.setMaximumSize(new Dimension(200, 20));
        password.setToolTipText("Пароль");

        JLabel authLabel = new JLabel("Offline");

        JButton authButton = new JButton("Авторизоваться");

        authButton.addActionListener(actionEvent -> {
            String lgn = login.getText();
            String psw = new String(password.getPassword());
            //todo: Добавить соообщение об ошибке с паролем(виснет)
            if (lgn != null && psw != null && !lgn.isEmpty() && !psw.isEmpty()) {
                try {
                    remove(login);
                    remove(password);
                    remove(authButton);
                    mainChat.getUI();
                    String nick = serverService.authorization(lgn, psw);
                    authLabel.setText("Online, nick " + nick);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Thread(() -> {
                    while (true) {
                        printToUI(mainChat, serverService.readMessages());
                    }
                }).start();
            }
        });

        add(login);
        add(password);
        add(authButton);
        add(authLabel);
    }

    private void sendMessage(JTextField myMessage) {
        serverService.sendMessage(myMessage.getText());
        myMessage.setText("");
    }

    private void printToUI(JTextArea mainChat, Message message) {
        mainChat.append("\n");
        mainChat.append((message.getNick() != null ? message.getNick() : "Сервер") + " написал: " + message.getMessage());
    }


}