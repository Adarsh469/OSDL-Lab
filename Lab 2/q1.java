public class q1 {

    public static void main(String[] args) {
        double primitiveTariff = 1500.50;
        int primitiveDays = 3;
        double primitiveServiceCharge = 450.75;

        Double roomTariff = primitiveTariff; 
        Integer daysStayed = primitiveDays;
        Double serviceCharges = primitiveServiceCharge;

        System.out.println("--- Hotel Guest Details ---");
        System.out.println("Room Tariff: Rs. " + roomTariff);
        System.out.println("Days Stayed: " + daysStayed);
        System.out.println("Service Charges: Rs. " + serviceCharges);

        double totalBill = (roomTariff * daysStayed) + serviceCharges;

        displayBill(totalBill);
    }

    public static void displayBill(double amount) {
        System.out.println("Final Bill Amount: Rs. " + amount);
    }
}