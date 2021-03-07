package Entity;

public class Product {
    private String serial_num;
    private String name;
    private double price;
    private String description;

    private String catalog_num;

    public void getCatalog(String catalog_num){}
    public void getProductInfo(String serial_num){}

    public double getPrice() {
        return price;
    }
}
