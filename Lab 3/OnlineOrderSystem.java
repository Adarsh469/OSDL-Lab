class Order implements Runnable{
    private String orderName;
    private int orderId;
    
    public Order(String orderName, int orderID){
        this.orderName = orderName;
        this.orderId = orderID;
    }
    
    @Override
    public void run() {
        System.out.println(orderName + "is now active for room number"+ orderId);
        for (int i = 0; i < 3; i++) {
            System.out.println("service "+orderName+"step "+i+"is being done in for order : "+ orderId);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(orderName + "thread was interrupted or stopped");
            }
        }
        System.out.println("the service "+orderName+"was completed for room : "+orderId);
    }
    
}

public class OnlineOrderSystem {
    public static void main(String[] args) {
        System.out.println("Hotel Management System");
        System.out.println("strating all service requests: \n");
        
        Order order1Validation = new Order("Order Validation", 1001);
        Order order1Payment = new Order("Payment Processing", 1001);
        Order order1Shipment = new Order("Order Shipment", 1001);

        Order order2Validation = new Order("Order Validation", 1002);
        Order order2Payment = new Order("Payment Processing", 1002);
        Order order2Shipment = new Order("Order Shipment", 1002);

        Thread t1 = new Thread(order1Validation);
        Thread t2 = new Thread(order1Payment);
        Thread t3 = new Thread(order1Shipment);
        Thread t4 = new Thread(order2Validation);
        Thread t5 = new Thread(order2Payment);
        Thread t6 = new Thread(order2Shipment);

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
            t6.start();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("thread interrupted");
        }

        System.out.println("all services have been started and done");
    }
}
