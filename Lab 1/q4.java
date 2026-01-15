
interface Amenities {
    void provideWifi();
    void provideBreakfast();
}

abstract class Room {
    protected int roomNumber;
    protected double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    abstract double calculateTariff();
    public void displayRoomDetails() {
        System.out.println("--- Room Details ---");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: $" + basePrice);
    }
}

class StandardRoom extends Room implements Amenities {
    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    double calculateTariff() {
        return basePrice + (basePrice * 0.10);
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi: Limited 2GB high-speed access included.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast: Continental breakfast available at the buffet.");
    }
}

class LuxuryRoom extends Room implements Amenities {
    public LuxuryRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    double calculateTariff() {
        return basePrice + (basePrice * 0.20) + 50.0;
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi: Unlimited ultra-high-speed access included.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast: Full English breakfast served in-room.");
    }
}

public class q4 {
    public static void main(String[] args) {
        Room myStandard = new StandardRoom(101, 100.0);
        Room myLuxury = new LuxuryRoom(505, 300.0);

        myStandard.displayRoomDetails();
        System.out.println("Total Tariff: $" + myStandard.calculateTariff());
        ((Amenities) myStandard).provideWifi(); 
        ((Amenities) myStandard).provideBreakfast();

        System.out.println();
        myLuxury.displayRoomDetails();
        System.out.println("Total Tariff: $" + myLuxury.calculateTariff());
        ((Amenities) myLuxury).provideWifi();
        ((Amenities) myLuxury).provideBreakfast();
    }
}