package server;


import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement createUserStatement;
    private static PreparedStatement getUserNicknameStatement;
    private static PreparedStatement changeUserNicknameStatement;
    private static PreparedStatement deleteUserStatement;

    public static boolean connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_chat", "root", "root");
            System.out.println("Connected to the database");
            statement = connection.createStatement();
            createUserTable();
            prepareAllStatement();
            createUser("white","white","White");
            createUser("pink", "pink", "Pink");
            createUser("blue", "blue", "Blue");
            createUser("orange", "orange", "Orange");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createUserTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                "    id       INTEGER      PRIMARY KEY" +
                "                          NOT NULL" +
                "                          UNIQUE," +
                "    login    VARCHAR (32) UNIQUE" +
                "                          NOT NULL," +
                "    password VARCHAR (32) NOT NULL," +
                "    nickname VARCHAR (32) UNIQUE" +
                "                          NOT NULL" +
                ");"
        );
    }

    public static void prepareAllStatement() throws SQLException {
        createUserStatement = connection.prepareStatement("INSERT INTO users (login, password, nickname) VALUES (?, ?, ?);");
        getUserNicknameStatement = connection.prepareStatement("SELECT nickname FROM users WHERE login = ? AND password = ?;");
        changeUserNicknameStatement = connection.prepareStatement("UPDATE users SET nickname = ? WHERE nickname = ?;");
        deleteUserStatement = connection.prepareStatement("DELETE FROM users WHERE login = ?;");
    }

    public static void createUser(String login, String password, String nickname) {
        try {
            createUserStatement.setString(1, login);
            createUserStatement.setString(2, password);
            createUserStatement.setString(3, nickname);
            createUserStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static String getUserNickname(String login, String password) {
        String nickname = null;
        try {
            getUserNicknameStatement.setString(1, login);
            getUserNicknameStatement.setString(2, password);
            ResultSet rs = getUserNicknameStatement.executeQuery();
            if (rs.next()) {
                nickname = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nickname;
    }

    public static boolean changeUserNickname(String currentNickname, String newNickname) {
        try {
            changeUserNicknameStatement.setString(1, newNickname);
            changeUserNicknameStatement.setString(2, currentNickname);
            changeUserNicknameStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteUser(String login) {
        try {
            deleteUserStatement.setString(1, login);
            deleteUserStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}