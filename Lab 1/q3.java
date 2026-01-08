import java.util.Scanner;

class Room {
    int roomNumber;
    double baseTariff;

    Room(int roomNumber, double baseTariff) {
        this.roomNumber = roomNumber;
        this.baseTariff = baseTariff;
    }

    double calculateTariff() {
        return baseTariff;
    }

    void displayInfo() {
        System.out.println("Room Number: " + roomNumber);
    }
}

class StandardRoom extends Room {
    double acCharge;

    StandardRoom(int roomNumber, double baseTariff, double acCharge) {
        super(roomNumber, baseTariff);
        this.acCharge = acCharge;
    }

    @Override
    double calculateTariff() {
        return baseTariff + acCharge;
    }
}

class LuxuryRoom extends Room {
    double amenityFee;
    double serviceTax;

    LuxuryRoom(int roomNumber, double baseTariff, double amenityFee, double serviceTax) {
        super(roomNumber, baseTariff);
        this.amenityFee = amenityFee;
        this.serviceTax = serviceTax;
    }

    @Override
    double calculateTariff() {
        return baseTariff + amenityFee + serviceTax;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Room roomRef; 

        System.out.println("Hotel Booking System");
        System.out.println("1. Book Standard Room");
        System.out.println("2. Book Luxury Room");
        System.out.print("Select room type: ");
        int choice = sc.nextInt();

        System.out.print("Enter Room Number: ");
        int rNo = sc.nextInt();
        System.out.print("Enter Base Tariff: ");
        double base = sc.nextDouble();

        if (choice == 1) {
            System.out.print("Enter AC Charges: ");
            double ac = sc.nextDouble();
            roomRef = new StandardRoom(rNo, base, ac);
        } else {
            System.out.print("Enter Amenity Fee: ");
            double amenity = sc.nextDouble();
            System.out.print("Enter Service Tax: ");
            double tax = sc.nextDouble();
            roomRef = new LuxuryRoom(rNo, base, amenity, tax);
        }

        System.out.println("\n--- Booking Receipt ---");
        roomRef.displayInfo();
        
        System.out.println("Total Calculated Tariff: " + roomRef.calculateTariff());

        sc.close();
    }
}
