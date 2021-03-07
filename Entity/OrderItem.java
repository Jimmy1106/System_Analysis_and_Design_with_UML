package Entity;

// Record the amount of each order-item.

public class OrderItem {
    
    private String Order_sNum;
    private int amount;

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getOrder_sNum() {
        return Order_sNum;
    }
    public void setOrder_sNum(String order_sNum) {
        Order_sNum = order_sNum;
    }

    public double getSubtotal(){
        return 0.0;
    }
}
