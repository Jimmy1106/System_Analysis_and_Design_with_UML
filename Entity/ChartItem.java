package Entity;

// Record the product quantity of each chart-item.

public class ChartItem {
    private String productNumber;
    private int productQuantity;

    public ChartItem(){}

    public ChartItem(String productNumber, int productQuantity){
        this.productNumber = productNumber;
        this.productQuantity = productQuantity;
    }

    public String getProductNumber() {
        return productNumber;
    }
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;   
    }

    public double getSubtotal(){
        
        Product product = new Product(); ////// 建構子可能要重寫
        product.getProductInfoFromDatabase(productNumber);

        return this.productQuantity*product.getPrice();
    }

}
