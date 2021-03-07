package Entity;

// Record the amount of each chart-item.

public class ChartItem {
    private String product_sNum;
    private int amount;


    public String getProduct_sNum() {
        return product_sNum;
    }
    public void setProduct_sNum(String product_sNum) {
        this.product_sNum = product_sNum;
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
