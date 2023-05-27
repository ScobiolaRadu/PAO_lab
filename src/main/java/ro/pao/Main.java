package ro.pao;

import ro.pao.application.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Secrets secrets = new Secrets();
        String url = secrets.getURL();
        String username = secrets.getUsername();
        String password = secrets.getPassword();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexiunea la baza de date a fost realizata cu succes!");
            Menu menu = new Menu(connection);
            menu.showMenu();

            connection.close();
            System.out.println("Conexiunea la baza de date a fost inchisa cu succes!");
        }

        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}