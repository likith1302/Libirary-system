import java.util.*;

public class libirary {
    static Scanner sc = new Scanner(System.in);
    Map<String, List<String>> books = new HashMap<>();

    public void add(String title, String author, Integer id, Integer price) {
        List<String> value = new ArrayList<>();
        value.add(title);
        value.add(author);
        value.add(String.valueOf(id));
        value.add(String.valueOf(price));
        books.put(title, value);
        System.out.println("Book added successfully");
    }

    public void delete(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    public void display(String title) {
        List<String> book = books.get(title);
        if (book != null) {
            System.out.println("***** Book Details *****");
            System.out.println("Name: " + book.get(0));
            System.out.println("Author: " + book.get(1));
            System.out.println("Id: " + book.get(2));
            System.out.println("Price: " + book.get(3));
            System.out.println("***********************");
        } else {
            System.out.println("Book not found");
        }
    }

    public void allbooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Map.Entry<String, List<String>> iter : books.entrySet()) {
                List<String> value = iter.getValue();
                display(value.get(0));
            }
        }
    }

    public static void main(String[] args) {
        libirary books = new libirary();
        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1) Add a book");
            System.out.println("2) Delete a book");
            System.out.println("3) Find a book");
            System.out.println("4) Display all books");
            System.out.println("5) Exi\n");
            System.out.print("Enter your choice: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (n) {
                case 1:
                    System.out.println("Enter Book Name:");
                    String title = sc.nextLine();
                    System.out.println("Enter Book Author:");
                    String author = sc.nextLine();
                    System.out.println("Enter Book ID:");
                    Integer id = sc.nextInt();
                    System.out.println("Enter Book Price:");
                    Integer price = sc.nextInt();
                    sc.nextLine(); // consume newline
                    books.add(title, author, id, price);
                    break;

                case 2:
                    System.out.println("Enter the book name you want to delete:");
                    String name = sc.nextLine();
                    books.delete(name);
                    break;

                case 3:
                    System.out.println("Enter the book name you want to find:");
                    String find = sc.nextLine();
                    books.display(find);
                    break;

                case 4:
                    books.allbooks();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            try {
        Thread.sleep(1000);  // Pause for 1000 milliseconds (1 second)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

        }
    }
}
