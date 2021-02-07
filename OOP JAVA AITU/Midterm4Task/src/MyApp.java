import controllers.BookController;

import java.util.Scanner;

public class MyApp {
    private final BookController bookController;
    private final Scanner scanner;

    public MyApp(BookController bookController) {
        this.bookController = bookController;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true) {
            System.out.println("Choose one option:\n 1) Search for any book by name\n 2) Get book by  id\n 3) Add book\n 4) Remove book\n");
            int choice = scanner.nextInt();

            if (choice == 1){
                searchBookByNameMenu();
            }
            else if (choice == 2){
                getBookByIdMenu();
            }
            else if (choice == 3){
                addBookMenu();
            }
            else if (choice == 4){
                removeBookByIdMenu();
            }
            else {
                break;
            }

        }
    }
    public void searchBookByNameMenu() {
        System.out.println("Please, write the name of book!");
        String name = scanner.next();
        String result = bookController.searchBookByName(name);
        System.out.println(result);
    }

    public void getBookByIdMenu() {
        System.out.println("Please, write the id of book!");
        int id = scanner.nextInt();
        String result = bookController.getBookById(id);
        System.out.println(result);
    }

    public void addBookMenu() {
        System.out.println("Please, write the name of book!");
        String name = scanner.next();
        System.out.println("Please, write the price of book!");
        double price = scanner.nextDouble();
        System.out.println("Please, write the Author's name of book!");
        String authorName = scanner.next();

        String result = bookController.addBook(name, price, authorName);
        System.out.println(result);
    }

    public void removeBookByIdMenu() {
        System.out.println("Please, write the id of book");
        int id = scanner.nextInt();

        String result = bookController.removeBookById(id);
        System.out.println(result);
    }


}
