package Entity;

// Record the amount of each chart-item.

public class ChartItem {
    private String productNumber;
    private int amount;


    public String getproductNumber() {
        return productNumber;
    }
    public void setproductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;   
    }

    public double getSubtotal(){
        // return getAmount()*(Produc(?).getPrice());
        return 0.0; 
    }

}
