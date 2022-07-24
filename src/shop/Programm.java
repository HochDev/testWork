package shop;

import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Programm {

    private static ProductList productList = new ProductList();;
    private static UsersList userList = new UsersList();
    private static PurchaseList purchaseList = new PurchaseList();;

    public static void main(String[] args) {

        showMainMenu();
        doMainMenu();

    }

    public static void showMainMenu() {

        System.out.println("Головне меню інтернет магазинe:");
        System.out.println("1. Створити користувача");
        System.out.println("2. Створити товар");
        System.out.println("3. Показати список користувачів");
        System.out.println("4. Показати список товарів");
        System.out.println("5. Здійснити покупку");
        System.out.println("7. Завершити роботу");
        System.out.println("Для продовження ведіть номер пункту меню:");
    }

    public static void doMainMenu() {

        Scanner sc = new Scanner(System.in);
        int numberMenu = sc.nextInt();

        switch (numberMenu) {
            case  (1):
                System.out.println("Ви вибрали пункт меню Створити користувача");
                AddUserMenu();
                break;
            case (2):
                System.out.println("Ви вибрали пункт меню Створити товар");
                AddProductMenu();
                break;
            case (3):
                System.out.println("Ви вибрали пункт меню Показати список користувачів");
                userList.DisplayUsersList();
                break;
            case (4):
                System.out.println("Ви вибрали пункт меню Показати список товарів");
                productList.DisplayProductList();
                break;
            case (5):
                System.out.println("Ви вибрали пункт меню Здійснити покупку");
                AddPurchaseMenu();
                break;
            case (6):
                System.out.println("Ви вибрали пункт меню Завершити роботу");
                break;
            default:
                System.out.println("Ви вибрали некоректний пункт меню. Буде показано головне меню!");
                showMainMenu();
                doMainMenu();
                break;
        }
    }

    public static void AddUserMenu() {

        System.out.println("Введіть ім'я користувача");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        System.out.println("Введіть прізвище користувача");
        String lastName = sc.nextLine();
        System.out.println("Введіть суму грошей в користувача");
        BigDecimal amountOfMoney = sc.nextBigDecimal();

        User user = new User(userList.getNewID(), firstName, lastName, amountOfMoney);
        userList.addUser(user);

    }

    public static void AddProductMenu() {

        System.out.println("Введіть назву товару ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Введіть вартість товару ");
        BigDecimal price = sc.nextBigDecimal();

        Product product = new Product(productList.getNewID(), name, price);
        productList.addProduct(product);

    }

    public static void AddPurchaseMenu() {

        System.out.println("Введіть id користувача");
        Scanner sc = new Scanner(System.in);
        int idUser = sc.nextInt();
        System.out.println("Введіть id товару");
        int idProduct = sc.nextInt();

        User user = userList.GetUserById(idUser);
        Product product  = productList.GetProductById(idProduct);

        if( user == null) {
            throw new IllegalArgumentException("Не вдалось знайти користувача");
        }

        if( product == null) {
            throw new IllegalArgumentException("Не вдалось знайти продукт");
        }

        BigDecimal amountOfMoneyUser = user.getAmountOfMoney();
        BigDecimal price             = product.getPrice();
        if(amountOfMoneyUser.compareTo(price) < 0) {
            throw new IllegalArgumentException("У користовача недостатньо коштів для здійсення покупки");
        }

        user.setAmountOfMoney(amountOfMoneyUser.subtract(price));

        Purchase purchase = new Purchase(idUser, idProduct);
        purchaseList.addPurchase(purchase);

    }
}