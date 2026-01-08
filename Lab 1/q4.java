abstract class Room {
    protected int roomNumber;
    protected double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public abstract double calculateTariff();

    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Total Tariff: " + calculateTariff());
    }
}

class StandardRoom extends Room {
    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculateTariff() {
        return basePrice * 1.10;
    }
}

class LuxuryRoom extends Room {
    public LuxuryRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculateTariff() {
        return (basePrice * 1.25) + 500;
    }
}

public class q4 {
    public static void main(String[] args) {
        Room room1 = new StandardRoom(101, 2000.0);
        Room room2 = new LuxuryRoom(202, 5000.0);

        room1.displayRoomDetails();
        System.out.println();
        room2.displayRoomDetails();
    }
}

