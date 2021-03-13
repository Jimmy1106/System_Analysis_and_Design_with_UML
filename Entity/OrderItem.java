package Entity;

// Record the quantity of each order-item.

public class OrderItem {
    
    private String orderNumber;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
