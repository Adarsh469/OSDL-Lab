class HotelService implements Runnable{
    private String serviceName;
    private int roomNumber;
    
    public HotelService(String serviceName, int roomNumber){
        this.serviceName = serviceName;
        this.roomNumber = roomNumber;
    }
    
    @Override
    public void run() {
        System.out.println(serviceName + "is now active for room number"+ roomNumber);
        for (int i = 0; i < 5; i++) {
            System.out.println("service "+serviceName+"step "+i+"is being done in room number : "+ roomNumber);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(serviceName + "thread was interrupted or stopped");
            }
        }
        System.out.println("the service "+serviceName+"was completed for room : "+roomNumber);
    }
                                                                                                                                                                                          
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        System.out.println("Hotel Management System");
        System.out.println("strating all service requests: \n");
        
        HotelService cleaning1 = new HotelService("Room CLeaning", 101);
        HotelService cleaning2 = new HotelService("Room CLeaning", 201);
        HotelService foodDelivery1 = new HotelService("Food Delivery", 102);
        HotelService foodDelivery2 = new HotelService("Food Delivery", 202);
        HotelService maintenance = new HotelService("maintenance", 301);

        Thread t1 = new Thread(cleaning1);
        Thread t2 = new Thread(cleaning2);
        Thread t3 = new Thread(foodDelivery1);
        Thread t4 = new Thread(foodDelivery2);
        Thread t5 = new Thread(maintenance);

        try {
            t1.start();
            Thread.sleep(500);
            t2.start();
            Thread.sleep(500);
            t3.start();
            Thread.sleep(500);
            t4.start();
            Thread.sleep(500);
            t5.start();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("thread interrupted");
        }

        System.out.println("all services have been started and done");
    }
}
