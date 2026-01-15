enum RoomType {
    STANDARD(1200.0),
    DELUXE(2500.0),
    SUITE(5000.0);

    private double baseTariff;
    RoomType(double baseTariff) {
        this.baseTariff = baseTariff;
    }
    public double getBaseTariff() {
        return this.baseTariff;
    }
    public double calculateTotalCost(int days) {
        return this.baseTariff * days;
    }
}

public class q2 {
    public static void main(String[] args) {
        RoomType selectedRoom = RoomType.DELUXE;
        int stayDuration = 4;

        double tariff = selectedRoom.getBaseTariff();
        double totalCost = selectedRoom.calculateTotalCost(stayDuration);

        System.out.println("=== Hotel Room Selection ===");
        System.out.println("Selected Room Type : " + selectedRoom);
        System.out.println("Base Tariff per Day: Rs. " + tariff);
        System.out.println("Duration of Stay   : " + stayDuration + " days");
        System.out.println("----------------------------");
        System.out.println("Total Room Tariff  : Rs. " + totalCost);
        System.out.println("----------------------------");
    }
}