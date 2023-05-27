package ro.pao.application;

import ro.pao.Services.GuitarService;
import ro.pao.Services.PianoService;
import ro.pao.Services.DrumsService;
import ro.pao.Services.ClientService;
import ro.pao.Services.Impl.GuitarServiceI;
import ro.pao.Services.Impl.PianoServiceI;
import ro.pao.Services.Impl.DrumsServiceI;
import ro.pao.Services.Impl.ClientServiceI;
import ro.pao.Models.Admin;
import ro.pao.Models.Client;
import ro.pao.Models.Drums;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;

import java.sql.Connection;
import java.util.Scanner;
import java.util.List;

import ro.pao.Repositories.impl.GuitarRepositoryI;
import ro.pao.Repositories.impl.PianoRepositoryI;
import ro.pao.Repositories.impl.DrumsRepositoryI;
import ro.pao.Repositories.impl.ClientRepositoryI;
import ro.pao.Repositories.impl.CartRepositoryI;

public class Menu {

    private GuitarService guitarService;
    private PianoService pianoService;
    private DrumsService drumsService;
    private ClientService clientService;

    public Menu(Connection connection) {
        this.guitarService = new GuitarServiceI(new GuitarRepositoryI(connection) {
        });
        this.pianoService = new PianoServiceI(new PianoRepositoryI(connection) {
        });
        this.drumsService = new DrumsServiceI(new DrumsRepositoryI(connection) {
        });
        this.clientService = new ClientServiceI(new ClientRepositoryI(connection) {
        }, new CartRepositoryI(connection) {
        });
    }

    Admin admin = new Admin("admin", "admin", "admin@gmail.com");

    void adminMenu() {
        int ok = 1;
        while (ok == 1) {

            System.out.println("1   Add Guitar");
            System.out.println("2   Update Guitar");
            System.out.println("3   Delete Guitar");
            System.out.println("4   Get All Guitars");
            System.out.println("5   Add Piano");
            System.out.println("6   Update Piano");
            System.out.println("7   Delete Piano");
            System.out.println("8   Get All Pianos");
            System.out.println("9   Add Drums");
            System.out.println("10   Update Drums");
            System.out.println("11   Delete Drums");
            System.out.println("12   Get All Drums");
            System.out.println("100   Logout");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.next()) {
                case "1":
                    System.out.println("Brand: ");
                    String brand = scanner.next();
                    System.out.println("Model: ");
                    String model = scanner.next();
                    System.out.println("Price: ");
                    int price = scanner.nextInt();
                    System.out.println("Stock: ");
                    int stock = scanner.nextInt();
                    System.out.println("Body: ");
                    String body = scanner.next();
                    Guitar guitar = new Guitar(brand, model, price, stock, body);
                    guitarService.addGuitar(guitar);
                    break;

                case "2":
                    System.out.println("Guitar id to update: ");
                    int id = scanner.nextInt();
                    System.out.println("New Guitar\n-----");
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Type: ");
                    body = scanner.next();
                    guitar = new Guitar(brand, model, price, stock, body);
                    guitarService.updateGuitar(id, guitar);
                    break;

                case "3":
                    System.out.println("Guitar id to delete: ");
                    id = scanner.nextInt();
                    guitarService.deleteGuitar(id);
                    break;

                case "4":
                    System.out.println(guitarService.getAllGuitars());
                    break;

                case "5":
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Key: ");
                    String key = scanner.next();
                    Piano piano = new Piano(brand, model, price, stock, key);
                    pianoService.addPiano(piano);
                    break;

                case "6":
                    System.out.println("Piano id to update: ");
                    id = scanner.nextInt();
                    System.out.println("New Piano:\n----- ");
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Key: ");
                    key = scanner.next();
                    piano = new Piano(brand, model, price, stock, key);
                    pianoService.updatePiano(id, piano);
                    break;

                case "7":
                    System.out.println("Piano id to delete: ");
                    id = scanner.nextInt();
                    pianoService.deletePiano(id);
                    break;

                case "8":
                    System.out.println(pianoService.getAllPianos());
                    break;

                case "9":
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Number of drums: ");
                    int nr_drums = scanner.nextInt();
                    Drums drums = new Drums(brand, model, price, stock, nr_drums);
                    drumsService.addDrums(drums);
                    break;

                case "10":
                    System.out.println("Drums id to update: ");
                    id = scanner.nextInt();
                    System.out.println("New Drums:\n----- ");
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Number of drums: ");
                    nr_drums = scanner.nextInt();
                    drums = new Drums(brand, model, price, stock, nr_drums);
                    drumsService.updateDrums(id, drums);
                    break;

                case "11":
                    System.out.println("Drums id to delete: ");
                    id = scanner.nextInt();
                    drumsService.deleteDrums(id);
                    break;

                case "12":
                    System.out.println(drumsService.getAllDrums());
                    break;

                case "100":
                    System.out.println("Logged out!");
                    ok = 0;
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Welcome " + admin.getUsername());
            adminMenu();
        } else {
            System.out.println("Wrong username or password");
        }
    }

    void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();

        Client client = new Client(username, password, email);
        clientService.createAccount(client);
    }

    void clientMenu(Client client) {
        int ok = 1;
        while (ok == 1) {
            System.out.println("1   View guitars");
            System.out.println("2   View pianos");
            System.out.println("3   View drums");
            System.out.println("4   Add guitar to cart");
            System.out.println("5   Add piano to cart");
            System.out.println("6   Add drums to cart");
            System.out.println("7   View cart");
            System.out.println("100   Logout");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.next()) {

                case "1":
                    System.out.println(guitarService.getAllGuitars());
                    break;

                case "2":
                    System.out.println(pianoService.getAllPianos());
                    break;

                case "3":
                    System.out.println(drumsService.getAllDrums());
                    break;

                case "4":
                    System.out.println("Brand: ");
                    String brand = scanner.next();
                    System.out.println("Model: ");
                    String model = scanner.next();
                    System.out.println("Price: ");
                    int price = scanner.nextInt();
                    System.out.println("Stock: ");
                    int stock = scanner.nextInt();
                    System.out.println("Body: ");
                    String body = scanner.next();

                    List<Guitar> guitars = guitarService.getAllGuitars();
                    Guitar guitar = new Guitar(brand, model, price, stock, body);
                    clientService.addGuitarToCart(client, guitar);
                    break;

                case "5":
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Key: ");
                    String key = scanner.next();

                    List<Piano> pianos = pianoService.getAllPianos();
                    Piano piano = new Piano(brand, model, price, stock, key);
                    clientService.addPianoToCart(client, piano);
                    break;

                case "6":
                    System.out.println("Brand: ");
                    brand = scanner.next();
                    System.out.println("Model: ");
                    model = scanner.next();
                    System.out.println("Price: ");
                    price = scanner.nextInt();
                    System.out.println("Stock: ");
                    stock = scanner.nextInt();
                    System.out.println("Number of drums: ");
                    int nr_drums = scanner.nextInt();
                    List<Drums> drumsList = drumsService.getAllDrums();
                    Drums drums = new Drums(brand, model, price, stock, nr_drums);
                    clientService.addDrumsToCart(client, drums);
                    break;

                case "7":
                    System.out.println(clientService.showCart(client));
                    break;

                case "100":
                    System.out.println("Logged out!");
                    clientService.emptyCart(client);
                    ok = 0;
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    void loginAsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();

        Client client = new Client();
        client.setUsername(username);
        client.setPassword(password);
        int allowed = clientService.login(client.getUsername(), client.getPassword());

        if (allowed != 0)
            clientMenu(client);
        else
            System.out.println("Wrong username or password");
    }

    public void showMenu() {

        while (true) {
            System.out.println("1   Login as Admin");
            System.out.println("2   Login as Client");
            System.out.println("3   Create Account");
            System.out.println("100   Exit");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.next()) {

                case "1":
                    loginAsAdmin();
                    break;

                case "2":
                    loginAsClient();
                    break;

                case "3":
                    createAccount();
                    break;

                case "100":

                    System.out.println("Bye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
                    break;

            }

        }
    }
}
