package Entity;

// Record the amount of each order-item.

public class OrderItem {
    
    private String orderNumber;
    private int amount;

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getSubtotal(){
        return 0.0;
    }
}
