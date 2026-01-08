import java.util.*;

class Books {
    private int bookID;
    private String bookTitle;
    private float price;
    private boolean availability;

    public void setBookID(int ID) { this.bookID = ID; }
    
    public void setBookTitle(String title) { this.bookTitle = title; }

    public void setBookPrice(float price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid input: price cannot be negative.");
            this.price = 0; 
        }
    }

    public void setAvailability(boolean x) { this.availability = x; }
    public int getBookID() { return bookID; }
    public String getBookTitle() { return bookTitle; }
    public float getBookPrice() { return price; }
    public boolean getAvailability() { return availability; }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();
        Books[] booksArray = new Books[n];

        for (int i = 0; i < n; i++) {
            booksArray[i] = new Books(); 
            System.out.println("\n--- Entering details for Book " + (i + 1) + " ---");

            System.out.print("Enter Book ID: ");
            booksArray[i].setBookID(sc.nextInt());
            sc.nextLine(); 

            System.out.print("Enter Book Title: ");
            booksArray[i].setBookTitle(sc.nextLine());

            System.out.print("Enter Price: ");
            booksArray[i].setBookPrice(sc.nextFloat());

            System.out.print("Is it available? (true/false): ");
            booksArray[i].setAvailability(sc.nextBoolean());
        }
        System.out.println("\nSummary of Books:");
        for (Books b : booksArray) {
            System.out.println("ID: " + b.getBookID() + " | Title: " + b.getBookTitle() + " | Price: $" + b.getBookPrice() + " | Available: " + b.getAvailability());
        }
        sc.close();
    }
}