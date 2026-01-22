// Each order task (validation, payment, shipment) runs in its own thread
class OrderTask implements Runnable {
    private String taskName;
    private int orderId;

    public OrderTask(String taskName, int orderId) {
        this.taskName = taskName;
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started for Order #" + orderId);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task: " + taskName + " | Step " + i + " | Order #" + orderId);
            try {
                // Simulate time-consuming operation (max delay in child thread)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(taskName + " thread was interrupted for Order #" + orderId);
            }
        }
        System.out.println(taskName + " completed for Order #" + orderId);
    }
}

public class OnlineOrderProcessingSystem {
    public static void main(String[] args) {
        System.out.println("=== Online Order Processing System ===");
        System.out.println("Starting order processing tasks...\n");

        // Create tasks for multiple orders
        OrderTask order1Validation = new OrderTask("Order Validation", 1001);
        OrderTask order1Payment = new OrderTask("Payment Processing", 1001);
        OrderTask order1Shipment = new OrderTask("Order Shipment", 1001);

        OrderTask order2Validation = new OrderTask("Order Validation", 1002);
        OrderTask order2Payment = new OrderTask("Payment Processing", 1002);
        OrderTask order2Shipment = new OrderTask("Order Shipment", 1002);

        // Wrap tasks in threads
        Thread t1 = new Thread(order1Validation);
        Thread t2 = new Thread(order1Payment);
        Thread t3 = new Thread(order1Shipment);

        Thread t4 = new Thread(order2Validation);
        Thread t5 = new Thread(order2Payment);
        Thread t6 = new Thread(order2Shipment);

        try {
            // Start threads with a small min delay in main thread
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
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nAll order tasks have been dispatched concurrently!");
    }
}