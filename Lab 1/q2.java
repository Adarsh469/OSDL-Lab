import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    double basePrice;

    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = 0.0;
    }

    Room(int roomNumber, String roomType, double basePrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = basePrice;
    }

    void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Base Price: " + basePrice);
    }
}

class DeluxeRoom extends Room {
    boolean freeWifi;
    boolean complimentaryBreakfast;

    DeluxeRoom(int roomNumber, String roomType, boolean wifi, boolean breakfast) {
        super(roomNumber, roomType);
        this.freeWifi = wifi;
        this.complimentaryBreakfast = breakfast;
    }

    DeluxeRoom(int roomNumber, String roomType, double basePrice, boolean wifi, boolean breakfast) {
        super(roomNumber, roomType, basePrice);
        this.freeWifi = wifi;
        this.complimentaryBreakfast = breakfast;
    }

    @Override
    void displayRoomDetails() {
        super.displayRoomDetails();
        System.out.println("Free Wi-Fi: " + (freeWifi ? "Yes" : "No"));
        System.out.println("Complimentary Breakfast: " + (complimentaryBreakfast ? "Yes" : "No"));
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Create Standard Room");
            System.out.println("2. Create Deluxe Room");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 3) break;

            System.out.print("Enter Room Number: ");
            int num = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter Room Type: ");
            String type = sc.nextLine();
            System.out.print("Enter Base Price: ");
            double price = sc.nextDouble();

            if (choice == 1) {
                Room r = new Room(num, type, price);
                System.out.println("\nRoom Created:");
                r.displayRoomDetails();
            } else if (choice == 2) {
                System.out.print("Free Wi-Fi (true/false): ");
                boolean wifi = sc.nextBoolean();
                System.out.print("Complimentary Breakfast (true/false): ");
                boolean breakfast = sc.nextBoolean();
                DeluxeRoom dr = new DeluxeRoom(num, type, price, wifi, breakfast);
                System.out.println("\nDeluxe Room Created:");
                dr.displayRoomDetails();
            }
        }
        sc.close();
    }
}
